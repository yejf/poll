package com.tarena.poll.biz;

import java.util.List;

import com.tarena.poll.entity.TUser;

/***************************
 * 
 * @author yejf
 *
 */
public interface IUserBiz {
 
	/*******************
	 * 登录 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws LoginException
	 */
	public abstract TUser login(String name, String pwd) throws LoginException;
	
	/*********************
	 * 注册
	 * @param user
	 * @throws BizException
	 */
	public abstract void register(TUser user) throws BizException;
	
	/*********************
	 * 更新或重置密码
	 * @param id
	 * @param newPwd
	 * @throws BizException
	 */
	public abstract void updatePassword(int id, String newPwd) throws BizException;
	
	/*******************************
	 * 依主键查找
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public abstract TUser getById(int id) throws BizException;
	
	public abstract List<TUser> findAllPM() throws BizException;
	public abstract List<TUser> findAllPMAndBzr() throws BizException;
	/**
	 * 按照姓名查找
	 * 
	 */
	public abstract TUser getByName(String name)throws BizException;
	/**
	 * 删除教师
	 * 
	 */
	public abstract void deleteTeacher(int id)throws BizException;
}
 
