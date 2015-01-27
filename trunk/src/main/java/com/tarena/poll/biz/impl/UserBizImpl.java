package com.tarena.poll.biz.impl;

import java.util.List;

import com.tarena.poll.biz.BizException;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.dao.IUserDao;
import com.tarena.poll.dao.impl.UserDaoImpl2;
import com.tarena.poll.entity.TUser;

public class UserBizImpl implements IUserBiz {

	public TUser login(String name, String pwd) {
		IUserDao iud = new UserDaoImpl2();
		TUser user = iud.findByNameAndPwd(name, pwd);
		return user;
	}

	public void register(TUser user) {
		IUserDao iud = new UserDaoImpl2();
		iud.saveUser(user);
	}

	public TUser getById(int id) throws BizException {
		IUserDao iud = new UserDaoImpl2();
		TUser user = iud.findById(id);
		return user;
	}

	public void updatePassword(int id, String newPwd) throws BizException {
		IUserDao iud = new UserDaoImpl2();
		iud.modifyPassword(id, newPwd);
	}

	public List<TUser> findAllPM() throws BizException {
		IUserDao iud = new UserDaoImpl2();
		return iud.findAllPM();
	}

	public TUser getByName(String name) throws BizException {
		IUserDao iud=new UserDaoImpl2();
		return iud.findByName(name);
	}

	@Override
	public void deleteTeacher(int id) throws BizException {
		IUserDao iud=new UserDaoImpl2();
		iud.deleteUser(id);
	}

	@Override
	public List<TUser> findAllPMAndBzr() throws BizException {
		IUserDao iud=new UserDaoImpl2();
		return iud.findAllPMAndBzr();
	}

}
