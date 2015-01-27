package com.tarena.poll.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.dao.IClassTypeDao;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class ClassTypeDaoImpl implements IClassTypeDao {

	@Override
	public void SaveType(TClassType classType) {
		Session s =HBDaoFactory.getSession();
		Transaction ts =s.getTransaction();
		try {
			ts.begin();
			s.save(classType);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	@Override
	public TClassType getType(Integer id) {
		Session s =HBDaoFactory.getSession();
		String hpl="from TClassType where id=:id";
		return (TClassType) s.createQuery(hpl).setParameter("id", id).uniqueResult();
	}

	@Override
	public List<TClassType> getTypes() {
		Session s =HBDaoFactory.getSession();
		String hpl="from TClassType";
		List<TClassType> types = s.createQuery(hpl).list();
		return types;
	}

	@Override
	public TClassType getTypeByName(String name) {
		Session s =HBDaoFactory.getSession();
		String hpl="from TClassType where typeName=:typeName";
		return (TClassType) s.createQuery(hpl).setParameter("typeName", name).uniqueResult();
	}

}
