package com.tarena.poll.dao;

import java.util.List;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.entity.TUser;

public interface IUserDao {
 
	/********************************
	 * 持儿化 用户 对像
	 * @param user
	 * @throws DaoException
	 */
	public abstract void saveUser(TUser user)throws DaoException;
	
	/********************************
	 * 更新用户信息
	 * @param user
	 * @throws DaoException
	 */
	public abstract void updateUser(TUser user)throws DaoException;
	
	/*************************************
	 * 删除指定ID 对应的用户记录
	 * @param id
	 * @throws DaoException
	 */
	public abstract void deleteUser(int id)throws DaoException;
	
	/**************************
	 * 根据ID 来查找用户记录，并返回用户对像
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public abstract TUser findById(int id)throws DaoException;
	
	/************************
	 * 根据用户名和密码来查找用户信息
	 * 没有找到返回 null
	 * @param name
	 * @param pwd
	 * @return
	 * @throws DaoException
	 */
	public abstract TUser findByNameAndPwd(String name, String pwd) 
													throws DaoException;
	
	/************************************
	 * 修改个人密码
	 * @param id
	 * @param newPwd  新密码
	 * @return 
	 * @throws DaoException
	 */
	public abstract TUser modifyPassword(int id, String newPwd) 
													throws DaoException;
	/************************************
	 * 查找所有的PM
	 * @return 
	 * @throws DaoException
	 */
	public abstract List<TUser> findAllPM() throws DaoException;
	public abstract List<TUser> findAllPMAndBzr() throws DaoException;
	/**************************
	 * 根据name 来查找用户记录，并返回用户对像
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public abstract TUser findByName(String name)throws DaoException;
	
}














 
