package com.tarena.poll.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.dao.DaoException;
import com.tarena.poll.dao.IUserDao;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TUser;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class UserDaoImpl2 implements IUserDao{

	@Override
	public void saveUser(TUser user) throws DaoException {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.save(user);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void updateUser(TUser user) throws DaoException {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.update(user);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void deleteUser(int id) throws DaoException {
		UserDaoImpl2 dao = new UserDaoImpl2();
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		String hql3="delete from TUser t where t.id=:id4";
		try {
			ts.begin();
			s.createQuery(hql3).setParameter("id4", id).executeUpdate();
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public TUser findById(int id) throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TUser where id=:id";
		TUser user =(TUser) s.createQuery(hql).setParameter("id", id).uniqueResult();
		s.close();
		return user;
	}

	@Override
	public TUser findByNameAndPwd(String name, String pwd) throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TUser where name=:name and passwd=:passwd";
		TUser user =(TUser) s.createQuery(hql).setParameter("name", name).setParameter("passwd", pwd).uniqueResult();
		s.close();
		return user;
	}

	@Override
	public TUser modifyPassword(int id, String newPwd) throws DaoException {
		UserDaoImpl2 dao = new UserDaoImpl2();
		TUser user=dao.findById(id);
		user.setPasswd(newPwd);
		dao.updateUser(user);
		return user;
	}

	@Override
	public List<TUser> findAllPM() throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TUser where type=3";
		List<TUser> users = s.createQuery(hql).list();
		s.close();
		return users;
	}

	@Override
	public TUser findByName(String name) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TUser where name=:name";
		return (TUser) s.createQuery(hql).setParameter("name", name).uniqueResult();
	}

	@Override
	public List<TUser> findAllPMAndBzr() throws DaoException {
		Session s = HBDaoFactory.getSession();
		String hql="from TUser where type=3 or type=2";
		List<TUser> users = s.createQuery(hql).list();
		s.close();
		return users;
	}
	
}
