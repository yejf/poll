package com.tarena.poll.web.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.tarena.poll.biz.IClazzBiz;
import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.biz.impl.ClazzBizImpl;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.biz.impl.UserBizImpl;
import com.tarena.poll.dao.IClassTypeDao;
import com.tarena.poll.dao.IUserDao;
import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.ClassTypeDaoImpl;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.entity.TUser;
import com.tarena.poll.web.forms.LoginForm;
import com.tarena.poll.web.forms.ModifyPasswdForm;
import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.commons.statics.ForwardPath;
import com.tarena.poll.commons.statics.ContextKey;
/**
 * PM、JD、PMO登录，退出及修改密码
 * @author liuxiaofei
 *
 */
public class UserAction extends MappingDispatchAction {
	/*
	 * 登录
	 */  
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		LoginForm login_form = (LoginForm)form;
		String name = login_form.getLoginName();
		String passwd = login_form.getPassword();
		
		IUserBiz iuz = new UserBizImpl();
		TUser user=null;
		user=iuz.getByName(name);
		
		ActionMessages messages = new ActionMessages();
		boolean flag=false;
		if(user==null){
			ActionMessage username_message = new ActionMessage("errors.username.no");
			messages.add("loginname", username_message);
			this.addErrors(request, messages);
			LogOutPut.getInstance().info("A user "+name+" login system,but fail!!");
			return mapping.findForward(ForwardPath.LOGIN_FAIL);
		}else{
//			String n=user.getName();
//			String p=user.getPasswd();
			if(user.getPasswd().equals(passwd)){
				flag=true;
			}else{
				ActionMessage password_message = new ActionMessage("errors.password.no");
				messages.add("password", password_message);
				request.setAttribute("name", name);
				this.addErrors(request, messages);
				LogOutPut.getInstance().info("A user "+name+" login system,but fail!!");
				return mapping.findForward(ForwardPath.LOGIN_FAIL);
			}
				
		}
		
		if(flag==true){
			int type = user.getType();
			/********
			 * PM身份登录系统   教学人员
			 */
			if(type == 3){
				session.setAttribute(ContextKey.CURRENT_USER, user);
				IPollBiz ipb = new PollBizImpl();
				List pollList = ipb.selectStatisticsByUserName(name);
				request.setAttribute("pmPollList", pollList);
				return mapping.findForward(ForwardPath.PM_LOGIN_SUCCESS);
			/********
			 * PMO身份登录系统   超级管理员
			 */
			} else if(type == 1){
				session.setAttribute(ContextKey.CURRENT_USER, user);
				IPollBiz ipb = new PollBizImpl();
				List unauditPollList = ipb.selectPollsByStatus('y');
				System.out.println(unauditPollList.size());
				request.setAttribute(ContextKey.UNAUDIT_POLL_LIST, unauditPollList);
				return mapping.findForward(ForwardPath.PMO_LOGIN_SUCCESS);
			/********
			 * 基地公用帐户身份登录系统   班主任
			 */
			} else if(type == 2){
				session.setAttribute(ContextKey.CURRENT_USER, user);
				IClassTypeDao dao = new ClassTypeDaoImpl();
				List<TClassType> types =dao.getTypes();
				request.getSession().setAttribute("types", types);
				IClazzBiz icb = new ClazzBizImpl();
				IUserBiz iub = new UserBizImpl();
				//IPollBiz biz = new PollBizImpl();
				/**
				 * 以下代码是用来在跳转到的页面当中只显示，没有被激活考评的班级
				 */
				Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
				List<TUser> pmList=iub.findAllPM();
				List<TClass> classList=icb.getByStatus(0);
				//List<TPoll> polls=biz.selectPollsByStatus('n');
				//删除classList中的班级
				/*if(class_poll_map != null){
					for(Iterator it=class_poll_map.keySet().iterator();it.hasNext();){
						TClass c=(TClass)it.next();
						for(Iterator it2 = classList.iterator();it2.hasNext();){
							TClass cla = (TClass)it2.next();
							if(c.getId().equals(cla.getId())){
								it2.remove();
							}
						}
					}
				}*/
			/*	if(polls!=null){
					for(Iterator it1=classList.iterator();it1.hasNext();){
						TClass c =(TClass) it1.next();
						for(Iterator it2=polls.iterator();it2.hasNext();){
							TPoll p=(TPoll) it2.next();
							if(p.getClazz().getClassName().equals(c.getClassName())){
								it1.remove();
								break;
							}
						}
					}
				}*/
				IpollTemplateDao templateDao = new PollTemplateDaoImpl();
				List<TPollTemplate> templates=templateDao.selectTemplateByType(1);
				request.getSession().setAttribute("templates", templates);
				request.getSession().setAttribute("classlists", classList);
				request.setAttribute(ContextKey.PM_LIST, pmList);
				request.setAttribute(ContextKey.POLL_LIST,class_poll_map);
				IPollBiz biz = new PollBizImpl();
				List<TPoll> polls=biz.selectPollsByStatus('n');
				for(TPoll p:polls){
					biz.delectLineByPoll(p);
				}
				biz.delectPollBystatus('n');
				return mapping.findForward(ForwardPath.JD_LOGIN_SUCCESS);
			}
		}
		
		return mapping.findForward(ForwardPath.LOGIN_FAIL);
	}
	/*******
	 * 退出系统，需要做两件事情；第一：将session中的user清除掉；第二：将session置为不可用
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute(ContextKey.CURRENT_USER);
		session.invalidate();//让session失效
		return mapping.findForward(ForwardPath.LOGOUT);
	}
	/**
	 * 保护页面，避免页面暴露在外
	 */
	public ActionForward toModifyPasswd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return mapping.findForward(ForwardPath.TO_PASSWD_MODIFY);
	}
	/**
	 * 重置密码的页面
	 */
	public ActionForward toResetPasswd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IUserBiz iub=new UserBizImpl();
		List<TUser> pms=iub.findAllPM();
		request.setAttribute(ContextKey.PM_LIST, pms);
		return mapping.findForward(ForwardPath.TO_PASSWD_RESET);
	}
	
	/*
	 * 修改密码
	 * 
	 * @修改记录如下：
	 * @date:2009-1-9
	 * @author:zhengxh
	 * @content :加入了对原密码的验证
	 */
	public ActionForward modifyPasswd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IUserBiz iub = new UserBizImpl();
		ModifyPasswdForm modifyPasswdForm = (ModifyPasswdForm)form;
		String newPasswd = modifyPasswdForm.getNewPassword();
		String reNewPasswd = modifyPasswdForm.getNewPasswordConfim();
		
		String oldPasswd=modifyPasswdForm.getOldPassword();
		TUser u=(TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER);
		if(!oldPasswd.equals(u.getPasswd())){
			ActionMessages messages = new ActionMessages();
			ActionMessage oldpasswd_message = new ActionMessage("errors.modify_password_fail");
			messages.add("oldPasswd", oldpasswd_message);
			this.addErrors(request, messages);
			LogOutPut.getInstance().info("A user "+u.getName()+"modify password,but fail!!");

			return mapping.findForward(ForwardPath.PASSWD_MODIFY_FAIL);
		}
		
		int id = ((TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER)).getId();
		if(newPasswd.equals(reNewPasswd)){
			iub.updatePassword(id, newPasswd);
			TUser user = (TUser)request.getSession().getAttribute(ContextKey.CURRENT_USER);
			user.setPasswd(newPasswd);
			request.getSession().setAttribute(ContextKey.CURRENT_USER, user);
		}
		
		return mapping.findForward(ForwardPath.PASSWD_MODIFY);
	}
	public ActionForward resetPasswd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("pmName"));
		IUserBiz iub=new UserBizImpl();
		iub.updatePassword(id, "888888");
		List<TUser> pms=iub.findAllPM();
		request.setAttribute(ContextKey.PM_LIST, pms);
		return mapping.findForward(ForwardPath.PASSWD_RESET);
	}
	/**
	 * JD密码修改之后要跳转的路径
	 */
	public ActionForward afterPasswdModify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IUserBiz iub = new UserBizImpl();
		IClazzBiz icb = new ClazzBizImpl();
		/*
		 *下面的代码是为了在密码修改之后，跳到的页面里的班级列表里只显示没有被激活考评的班级 
		 */
		Map<TClass,TPoll>class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		List<TUser> pmList=iub.findAllPM();
		List<TClass> classList=icb.getByStatus(0);
		
		//删除classList中的班级
		if(class_poll_map != null){
			for(Iterator it=class_poll_map.keySet().iterator();it.hasNext();){
				TClass c=(TClass)it.next();
				for(Iterator it2 = classList.iterator();it2.hasNext();){
					TClass cla = (TClass)it2.next();
					if(c.getId().equals(cla.getId())){
						it2.remove();
					}
				}
			}
		}
	
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		return mapping.findForward(ForwardPath.JD_ACTIVATE_LIST);
	}
	


	
}