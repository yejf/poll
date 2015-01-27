package com.tarena.poll.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.dao.DaoException;
import com.tarena.poll.dao.IPollDao;
import com.tarena.poll.entity.Statistics;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TUser;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class PollDaoImpl2 implements IPollDao{

	@Override
	public void savePoll(TPoll poll) throws DaoException {
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.save(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void modifyOverDate(int pollId) throws DaoException {
		PollDaoImpl2 dao = new PollDaoImpl2();
		TPoll poll = dao.selectPollById(pollId);
		poll.setOver_date(new Date());
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.update(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
		
	}

	@Override
	public void modifyPollStatus(char newStatus, int id) throws DaoException {
		PollDaoImpl2 dao = new PollDaoImpl2();
		TPoll poll = dao.selectPollById(id);
		poll.setStatus(newStatus);
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.update(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void updatePoll(TPoll poll) throws DaoException {
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.update(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void deletePoll(int id) throws DaoException {
		PollDaoImpl2 dao = new PollDaoImpl2();
		TPoll poll = dao.selectPollById(id);
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.delete(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public List selectPollsByInfo(int classId, int userId, Date start, Date end)
			throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TPoll t where t.clazz.id=:id1 and t.user.id=:id2 and created_date=:start and over_date=:end";
		List<TPoll> polls = s.createQuery(hql).setParameter("id1", classId).setParameter("id2", userId).setParameter("start", start).setParameter("end", end).list();
		s.close();
		return polls;
	}

	@Override
	public List selectPollsByDate(Date begin, Date end) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TPoll where created_date=:start and over_date=:end";
		List<TPoll> polls = s.createQuery(hql).setParameter("start", begin).setParameter("end", end).list();
		s.close();
		return polls;
	}

	@Override
	public List selectPollsByStatus(char status) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TPoll where status=:status";
		List<TPoll> polls = s.createQuery(hql).setParameter("status", status).list();
		s.close();
		return polls;
	}

	@Override
	public void savePollLine(TPollLine pollLine) throws DaoException {
		Session s=null;
		Transaction ts = null;
		try {
			s = HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.save(pollLine);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public List selectPollLineByPollId(int pollId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPoll selectPollById(int id) throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TPoll where id=:id";
		TPoll poll = (TPoll) s.createQuery(hql).setParameter("id", id).uniqueResult();
		Hibernate.initialize(poll.getPollLines());
		s.close();
		return poll;
	}

	@Override
	public Statistics selectStatisticsById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPollLine selectPollLineById(int id) throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TPollLine where id=:id";
		TPollLine pollline = (TPollLine) s.createQuery(hql).setParameter("id", id).uniqueResult();
		s.close();
		return pollline;
	}

	@Override
	public List selectStatisticsByUserName(String name) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLastPoll() throws DaoException {
		Session s=null;
		Transaction ts =null;
		try {
			s=HBDaoFactory.getSession();
			String hql="from TPoll where id=(select max(id) from TPoll)";
			TPoll poll=(TPoll) s.createQuery(hql).uniqueResult();
			ts=s.getTransaction();
			ts.begin();
			s.delete(poll);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public TPoll getLastPoll() throws DaoException {
		Session s=HBDaoFactory.getSession();
		String hql="from TPoll where id=(select max(id) from TPoll)";
		TPoll poll=(TPoll) s.createQuery(hql).uniqueResult();
		Hibernate.initialize(poll.getTemplate());
		Hibernate.initialize(poll.getTemplate().getContents());
		s.close();
		return poll;
	}

	@Override
	public List<TPollLine> selectPollLineByPoll(TPoll poll) throws DaoException {
		Session s=HBDaoFactory.getSession();
		String hql="from TPollLine where poll=:poll";
		List<TPollLine> lines=s.createQuery(hql).setParameter("poll", poll).list();
		s.close();
		return lines;
	}

	@Override
	public void delectPollBystatus(Character status) throws DaoException {
		Session s=HBDaoFactory.getSession();
		String hql="from TPoll where status=:status";
		List<TPoll> polls=s.createQuery(hql).setParameter("status", status).list();
		PollDaoImpl2 impl= new PollDaoImpl2();
		for(TPoll p :polls){
			impl.deletePoll(p.getId());
		}
		s.close();
	}

	@Override
	public void delectPollByUser(TUser user) throws DaoException {
		Session s=HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			String hql="from TPoll where user=:user";
			List<TPoll> polls=s.createQuery(hql).setParameter("user", user).list();
			PollDaoImpl2 impl= new PollDaoImpl2();
			for(TPoll p :polls){
				impl.deletePoll(p.getId());
			}
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
		
	}

	@Override
	public void delectLineByPoll(TPoll poll) throws DaoException {
		Session s=HBDaoFactory.getSession();
		String hql="from TPollLine where poll=:poll";
		List<TPollLine> lines = s.createQuery(hql).setParameter("poll", poll).list();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			for(TPollLine l:lines){
				s.delete(l);
			}
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
		
	}

	@Override
	public List<TPoll> selectPollsByUser(TUser user) throws DaoException {
		Session s=HBDaoFactory.getSession();
		String hql="from TPoll where user=:user";
		List<TPoll> polls = s.createQuery(hql).setParameter("user", user).list();
		s.close();
		return polls;
	}

	@Override
	public List<TPoll> selectPollsByYear(int year) throws DaoException {
		Calendar cal1=Calendar.getInstance();
		cal1.set(year, 0, 1);
		Date d1=cal1.getTime();
		Calendar cal2=Calendar.getInstance();
		cal2.set(year, 11, 31);
		Date d2=cal2.getTime();
		Session s=HBDaoFactory.getSession();
		String hql="from TPoll where checked_date>:date1 and checked_date<:date2";
		List<TPoll> polls = s.createQuery(hql).setParameter("date1", d1).setParameter("date2", d2).list();
		s.close();
		return polls;
	}

	@Override
	public List<TPoll> selectPollsByYearAndMonth(int year, int month)
			throws BizException {
		Calendar cal1=Calendar.getInstance();
		cal1.set(year, month-1, 1);
		Date d1=cal1.getTime();
		Calendar cal2=Calendar.getInstance();
		cal2.set(year, month-1,cal2.getActualMaximum(Calendar.DATE));
		Date d2=cal2.getTime();
		Session s=HBDaoFactory.getSession();
		String hql="from TPoll where checked_date>:date1 and checked_date<:date2";
		List<TPoll> polls = s.createQuery(hql).setParameter("date1", d1).setParameter("date2", d2).list();
		s.close();
		return polls;
	}

	@Override
	public List<TPoll> selectPollsByYearAndQuarter(int year, int quarter)
			throws DaoException {
			Calendar cal1=Calendar.getInstance();
			cal1.set(year, (quarter-1)*3, 1);
			Date d1=cal1.getTime();
			Calendar cal2=Calendar.getInstance();
			if(quarter*3==3||quarter*3==12){
				cal2.set(year, quarter*3-1,31);
			}else{
				cal2.set(year, quarter*3-1,30);
			}
			Date d2=cal2.getTime();
			Session s=HBDaoFactory.getSession();
			String hql="from TPoll where checked_date>:date1 and checked_date<:date2";
			List<TPoll> polls = s.createQuery(hql).setParameter("date1", d1).setParameter("date2", d2).list();
			s.close();
			return polls;
	}

}
