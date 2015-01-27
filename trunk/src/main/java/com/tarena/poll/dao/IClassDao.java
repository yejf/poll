package com.tarena.poll.dao;

import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;

import java.util.List;

/**************************
 * 
 * @author yejf
 *
 */
public interface IClassDao {
 
	/************************
	 * 持久化班级信息 
	 * @param clazz
	 */
	public abstract void saveClass(TClass clazz) throws DaoException;
	
	/*************************
	 * 更新班级信息
	 * @param clazz
	 */
	public abstract void updateClass(TClass clazz)throws DaoException;
	
	/************************
	 * 删除指定ID的数据库班级记录
	 * @param id
	 */
	public abstract void deleteClass(int id)throws DaoException;
	
	/********************
	 * 根据指定ID来查找数据库班级记录
	 * @param id
	 * @return
	 */
	public abstract TClass findById(int id)throws DaoException;
	
	/**************************
	 * 根据班级名来查询班级； 
	 * 支持 "模糊查询"
	 * @param className
	 * @return
	 */
	public abstract List findByClassName(String className)throws DaoException;
	
	/*******************************
	 * 查找所有班级信息
	 * @return
	 */
	public abstract List findAll() throws DaoException;
	
	/*****************************
	 * 根据班级 类型 查询班级信息
	 * @param type
	 * @return
	 */
	public abstract List findByType(TClassType type)throws DaoException;
	
	
	/***********************************
	 * 根据班级 状态 查询班级信息
	 * 状态为两种： 0 表示 未毕业， 1 表示已毕业
	 * @param status
	 * @return
	 */
	public abstract List<TClass> findByStatus(int status) throws DaoException;
	
	
}
 




