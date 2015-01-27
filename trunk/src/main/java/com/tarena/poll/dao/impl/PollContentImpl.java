package com.tarena.poll.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.dao.IPollContentDao;
import com.tarena.poll.entity.TPollContent;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class PollContentImpl implements IPollContentDao{

	@Override
	public void savePollContent(TPollContent content) {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.save(content);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public List<TPollContent> getByTypeAndStatus(String type,int status) {
		Session s = HBDaoFactory.getSession();
		String hql = "from TPollContent where type=:type and status=:status";
		List<TPollContent> contents =s.createQuery(hql).setParameter("type", type).setParameter("status", status).list();
		s.close();
		return contents;
	}

	@Override
	public List<TPollContent> getByStatus(int status) {
		Session s = HBDaoFactory.getSession();
		String hql = "from TPollContent where status=:status";
		List<TPollContent> contents =s.createQuery(hql).setParameter("status", status).list();
		s.close();
		return contents;
	}

	@Override
	public void modifyContentAllClose() {
		Session s = HBDaoFactory.getSession();
		String hql="update TPollContent set status=1";
		s.beginTransaction();
		s.createQuery(hql).executeUpdate();
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void modifyContentByIdAndStatus(int id, int status) {
		Session s = HBDaoFactory.getSession();
		String hql="update TPollContent set status=:status where id=:id";
		s.beginTransaction();
		s.createQuery(hql).setParameter("id", id).setParameter("status", status).executeUpdate();
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	public void modifyContentByIdAndName(int id, String name) {
		Session s = HBDaoFactory.getSession();
		String hql="update TPollContent set content=:name where id=:id";
		s.beginTransaction();
		s.createQuery(hql).setParameter("id", id).setParameter("name", name).executeUpdate();
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	public List<String> selectTypes() {
		Session s = HBDaoFactory.getSession();
		String hql="select distinct type from TPollContent";
		List<String> list= s.createQuery(hql).list();
		s.close();
		return list;
	}

	@Override
	public List<TPollContent> getAll() {
		Session s = HBDaoFactory.getSession();
		String hql="from TPollContent order by type";
		List<TPollContent> list = s.createQuery(hql).list();
		s.close();
		return null;
	}

}
