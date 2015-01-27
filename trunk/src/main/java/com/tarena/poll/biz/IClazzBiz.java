package com.tarena.poll.biz;

import java.util.List;

import com.tarena.poll.entity.TClass;

/************************
 * 
 * @author yejf
 *
 */
public interface IClazzBiz {
 
	/******
	 * 增加一个班级
	 * @param clazz
	 * @throws BizException
	 */
	public abstract void addClass(TClass clazz) throws BizException;
	
	/**************
	 * 根据班级ID查找班级
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public abstract TClass getClassById(int id) throws BizException ;
	
	/*************
	 * 根据班级状态查找班级
	 * @param status
	 * @return
	 * @throws BizException
	 */
	public abstract List<TClass> getByStatus(int status) throws BizException;
	
	/*************
	 * 更新班级信息
	 * @param status
	 * @return
	 * @throws BizException
	 */
	public abstract void updateClass(TClass clazz) throws BizException;
	
	/*************
	 * 根据班级名称查找班级
	 * @param status
	 * @return
	 * @throws BizException
	 */
	public abstract List findByClassName(String className)throws BizException;
	
	/*******************************
	 * 查找所有班级信息
	 * @return
	 */
	public abstract List getAll() throws BizException;
}
 








