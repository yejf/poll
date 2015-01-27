package com.tarena.poll.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.dao.DaoException;
import com.tarena.poll.dao.IClassDao;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class ClassDaoImpl2 implements IClassDao{

	@Override
	public void saveClass(TClass clazz) throws DaoException {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.save(clazz);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void updateClass(TClass clazz) throws DaoException {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.update(clazz);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public void deleteClass(int id) throws DaoException {
		ClassDaoImpl2 dao = new ClassDaoImpl2();
		TClass c = dao.findById(id);
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.delete(c);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public TClass findById(int id) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TClass where id=:id";
		TClass c=(TClass) s.createQuery(hql).setParameter("id", id).uniqueResult();
		s.close();
		return c;
	}

	@Override
	public List findByClassName(String className) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TClass where className=:className";
		List<TClass> classes=s.createQuery(hql).setParameter("className", className).list();
		s.close();
		return classes;
	}

	@Override
	public List findAll() throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TClass";
		List<TClass> classes=s.createQuery(hql).list();
		s.close();
		return classes;
	}

	@Override
	public List findByType(TClassType type) throws DaoException {
		return null;
	}

	@Override
	public List<TClass> findByStatus(int status) throws DaoException {
		Session s =HBDaoFactory.getSession();
		String hql="from TClass where status=:status";
		List<TClass> classes=s.createQuery(hql).setParameter("status", status).list();
		s.close();
		return classes;
	}

}
