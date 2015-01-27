package com.tarena.poll.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.util.HBDaoFactory;

/**
 *本来用来演示
 *author datong
 */
public class PollTemplateDaoImpl implements IpollTemplateDao {

	@Override
	public void saveTemplate(TPollTemplate template) {
		Session s=null;
		Transaction ts=null;
		try {
			s= HBDaoFactory.getSession();
			ts =s.getTransaction();
			ts.begin();
			s.save(template);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
		
	}

	@Override
	public List<TPollTemplate> selectTemplateByType(int type) {
		Session s = HBDaoFactory.getSession();
		String hql = "from TPollTemplate where type=:type";
		List<TPollTemplate> templates=s.createQuery(hql).setParameter("type", type).list();
		s.close();
		return templates;
	}

	@Override
	public List<TPollTemplate> selectAll() {
		Session s = HBDaoFactory.getSession();
		String hql = "from TPollTemplate";
		List<TPollTemplate> templates=s.createQuery(hql).list();
		s.close();
		return templates;
	}

	@Override
	public void modifyAllClose() {
		Session s = HBDaoFactory.getSession();
		String hql = "update TPollTemplate set type=2";
		s.beginTransaction();
		s.createQuery(hql).executeUpdate();
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void modifyByIdAndType(int id, int type) {
		Session s = HBDaoFactory.getSession();
		String hql = "update TPollTemplate set type=:type where id=:id";
		s.beginTransaction();
		s.createQuery(hql).setParameter("type", type).setParameter("id", id).executeUpdate();
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public TPollTemplate selectById(int id) {
		Session s = HBDaoFactory.getSession();
		String hql="from TPollTemplate where id=:id";
		TPollTemplate t=(TPollTemplate) s.createQuery(hql).setParameter("id", id).uniqueResult();
		Hibernate.initialize(t.getContents());
		s.close();
		return t;
	}

}
