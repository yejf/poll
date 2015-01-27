package com.tarena.poll.biz.impl;

import java.util.List;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.biz.IClazzBiz;
import com.tarena.poll.dao.IClassDao;
import com.tarena.poll.dao.impl.ClassDaoImpl2;
import com.tarena.poll.entity.TClass;

public class ClazzBizImpl implements IClazzBiz {

	public void addClass(TClass clazz) {
		IClassDao icd = new ClassDaoImpl2();
		icd.saveClass(clazz);
	}

	public TClass getClassById(int id) {
		IClassDao icd = new ClassDaoImpl2();
		TClass clazz = icd.findById(id);
		return clazz;
	}

	public List findByClassName(String className) throws BizException {
		IClassDao icd = new ClassDaoImpl2();
		List clazzes = icd.findByClassName(className);
		return clazzes;
	}

	public List getAll() throws BizException {
		IClassDao icd = new ClassDaoImpl2();
		List clazzes = icd.findAll();
		return clazzes;
	}

	public List<TClass> getByStatus(int status) throws BizException {
		IClassDao icd = new ClassDaoImpl2();
		List<TClass> clazzes = icd.findByStatus(status);
		return clazzes;
	}

	public void updateClass(TClass clazz) throws BizException {
		IClassDao icd = new ClassDaoImpl2();
		icd.updateClass(clazz);
	}

}
