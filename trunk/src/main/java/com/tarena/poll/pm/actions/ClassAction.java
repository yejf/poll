package com.tarena.poll.pm.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

import com.tarena.poll.biz.IClazzBiz;
import com.tarena.poll.biz.IUserBiz;
import com.tarena.poll.biz.impl.ClazzBizImpl;
import com.tarena.poll.biz.impl.UserBizImpl;
import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.statics.ForwardPath;
import com.tarena.poll.dao.IClassTypeDao;
import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.ClassTypeDaoImpl;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.entity.TUser;
import com.tarena.poll.pm.forms.ClassForm;

/**
 * PM对班级的一些操作所对应的方法
 * @author liuxiaofei
 *  
 */
public class ClassAction extends MappingDispatchAction {
	private Lock lock=new ReentrantLock();
	
	/*****
	 * 基地帐户为增加班级服务,隐藏jsp页面的路径
	 */
	public ActionForward jdToAddClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//LogOutPut.getInstance().debug("**************jdToAddClass()");
//		IClassTypeDao dao = new ClassTypeDaoImpl();
//		List<TClassType> types =dao.getTypes();
//		request.getSession().setAttribute("types", types);
		//request.setAttribute("types", types);
		return mapping.findForward(ForwardPath.JDT_CLASS_TO_ADD);
	}
	/*****
	 * PM为增加班级服务，保留
	 */
	public ActionForward toAddClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward(ForwardPath.PM_CLASS_TO_ADD);
	}
	/******
	 * PM增加班级，保留
	 */
	public ActionForward addClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward(ForwardPath.PM_CLASS_ADD);
	}
	/***
	 * 基地公用帐户增加班级
	 */
	public ActionForward jdtAddClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IClazzBiz icb = new ClazzBizImpl();
		IUserBiz iub = new UserBizImpl();

		String className=request.getParameter("className");
		List list=icb.findByClassName(className);
		for(Object obj:list){
			TClass c=(TClass)obj;
			if(c.getClassName().equals(className)){
				ActionMessages messages = new ActionMessages();
				ActionMessage add_class_fail_message = new ActionMessage("errors.add_class_fail");
				messages.add("add_fail", add_class_fail_message);
				this.addErrors(request, messages);
				LogOutPut.getInstance().info("Add "+className+" ,but fail!!");
				return mapping.findForward(ForwardPath.JDT_CLASS_TO_ADD);
			}
		}
		/** modify by yejf on 2009/10/14, remove the code was order to make the different class use same ip  */
		/*
		List allClass=icb.getByStatus(0); //找出所有未毕业班级
		for(Object o:allClass){
			TClass clz=(TClass)o;
			if(clz.getClassIP().equals(clazz.getClassIP())){
				ActionMessages messages = new ActionMessages();
				ActionMessage add_class_fail_message = new ActionMessage("errors.add_class_fail_ip");
				messages.add("add_fail_ip", add_class_fail_message);
				this.addErrors(request, messages);
				LogOutPut.getInstance().info("Add "+clazz.getClassName()+" ,but fail!!");
				return mapping.findForward(ForwardPath.JDT_CLASS_TO_ADD);
			}
		}
		*/
		
		//LogOutPut.getInstance().debug("**************jdtAddClass()"+clazz);
		String typeName = request.getParameter("classType");
		IClassTypeDao dao = new ClassTypeDaoImpl();
		TClassType type =dao.getTypeByName(typeName);
		String ip = request.getParameter("classIP");
		String remark = request.getParameter("remark");
		
		TClass clazz = new TClass(null, className, type, ip, 0, remark, null);
		request.setAttribute("newClazz", clazz);
		icb.addClass(clazz);
		/**
		 * 以下代码是用来在跳转到的页面当中只显示，没有被激活考评的班级
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
		request.getSession().setAttribute("classlists", classList);
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		return mapping.findForward(ForwardPath.JDT_CLASS_ADD);
	}
	/*******
	 * 去查询指定班级的信息，为修改班级服务
	 */
	public ActionForward toModifyClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	public ActionForward jdToModifyClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IClazzBiz icb = new ClazzBizImpl();
		
		if(request.getParameter("classId")==null){			
//			List classList = icb.getByStatus(0);
			List classList = icb.getAll();
			request.setAttribute(ContextKey.CLASS_LIST, classList);
			return mapping.findForward(ForwardPath.JDT_CLASS_TO_MODIFY);
		} else{				
			int id = Integer.parseInt(request.getParameter("classId"));
			TClass clazz = icb.getClassById(id);
//			List classList = icb.getByStatus(0);
			List classList = icb.getAll();
			request.setAttribute(ContextKey.CLASS_LIST, classList);
			request.setAttribute(ContextKey.CLASS_BY_ID, clazz);
			return mapping.findForward(ForwardPath.JDT_CLASS_TO_MODIFY);
		}
	}
	/********
	 * PM修改班级
	 */
	public ActionForward modifyClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return mapping.findForward(ForwardPath.PM_CLASS_MODIFY);
	}
	/******
	 * 基地公用帐户修改班级
	 */
	public ActionForward jdtModifyClass(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
		IClazzBiz icb = new ClazzBizImpl();
		IUserBiz iub = new UserBizImpl();
		TPoll poll = null;
		Integer ids =Integer.parseInt(request.getParameter("id"));
		TClass clazz=icb.getClassById(ids);
		
		String className=request.getParameter("className");
		IClassTypeDao dao = new ClassTypeDaoImpl();
		String typename=request.getParameter("classType");
		TClassType classType=dao.getTypeByName(typename);
		String classIP=request.getParameter("classIP");
		int status=Integer.parseInt(request.getParameter("status"));
		String remark = request.getParameter("remark");
		clazz.setClassIP(classIP);
		clazz.setClassName(className);
		clazz.setClassType(classType);
		clazz.setRemark(remark);
		clazz.setStatus(status);
		
		
		/*
		 * 判断数据库中是否有同名班级
		 */
		List<TClass> lists=icb.findByClassName(clazz.getClassName());
		for(Object obj:lists){
			TClass c1=(TClass)obj;
			if(c1.getClassName().equals(clazz.getClassName())&&!(c1.getId().equals(clazz.getId()))){
				int id = clazz.getId();
				TClass c = icb.getClassById(id);
				List classList = icb.getByStatus(0);
				request.setAttribute(ContextKey.CLASS_LIST, classList);
				request.setAttribute(ContextKey.CLASS_BY_ID, c);	
				
				ActionMessages messages = new ActionMessages();
				ActionMessage modify_class_fail_message = new ActionMessage("errors.modify_class_fail");
				messages.add("classname", modify_class_fail_message);
				this.addErrors(request, messages);
						
				LogOutPut.getInstance().info("Modify "+clazz.getClassName()+" ,but fail!!");
				return mapping.findForward(ForwardPath.JDT_CLASS_TO_MODIFY);
			}
		}

		/** modify by yejf on 2009/10/14, remove the code was order to make the different class use same ip  */
		/*
		List allClass=icb.getByStatus(0);
		for(Object o:allClass){
			TClass clz=(TClass)o;
			if(clz.getClassIP().equals(clazz.getClassIP())&&!(clz.getId().equals(clazz.getId()))){
				int id = clazz.getId();
				TClass c = icb.getClassById(id);
				List classList = icb.getByStatus(0);
				request.setAttribute(ContextKey.CLASS_LIST, classList);
				request.setAttribute(ContextKey.CLASS_BY_ID, c);
				
				ActionMessages messages = new ActionMessages();
				ActionMessage add_class_fail_message = new ActionMessage("errors.modify_class_fail_ip");
				messages.add("classip", add_class_fail_message);
				this.addErrors(request, messages);
				LogOutPut.getInstance().info("modify "+clazz.getClassName()+" ,but fail!!");
				return mapping.findForward(ForwardPath.JDT_CLASS_TO_MODIFY);
			}
		}
		*/

		Map<TClass,TPoll> map = (Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		boolean flag = false;
	
		if(map!=null&&map.size()!=0&&!map.isEmpty()){
			Iterator<TClass> it = map.keySet().iterator();  
			while(it.hasNext()){
				TClass clz = it.next();
				if(clz.getId().equals(clazz.getId())){
					poll = map.get(clz);
					lock.lock();
					it.remove();
					lock.unlock();
					flag = true;
					break;
					
				}
			}
		}
		
		if(flag){
			poll.setClazz(clazz);
			lock.lock();
			map.put(clazz, poll);
			poll=null;
			request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP,map);
			lock.unlock();
		}
		icb.updateClass(clazz);
		/**
		 * 以下代码是用来在跳转到的页面当中只显示，没有被激活考评的班级
		 */
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		List<TUser> pmList=iub.findAllPM();
		List<TClass> classList=icb.getByStatus(0);
		

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
		request.getSession().setAttribute("classlists", classList);
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		request.getSession().getServletContext().setAttribute(ContextKey.CLASS_POLL_MAP, map);
		return mapping.findForward(ForwardPath.JDT_CLASS_MODIFY);
	}
	/**
	 * 根据班级名称查找班级
	 */
	public ActionForward queryClassByName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IClazzBiz icb = new ClazzBizImpl();
		String className = request.getParameter("className");//此处需要沟通之后最后确定
		List clazzs = icb.findByClassName(className);
		
		//LogOutPut.getInstance().debug("**************aueryClassByName()");
		
		request.setAttribute(ContextKey.CLAZZS, clazzs);
		return mapping.findForward(ForwardPath.PM_CLASS_QUERY_NAME);
	}
	/*******
	 * 删除班级，保留的方法
	 */
	public ActionForward removeClass(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward(ForwardPath.PM_CLASS_REMOVE);
	}
	/**
	 * 保留的方法，现在还没有实现
	 */
	public ActionForward classList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return mapping.findForward(ForwardPath.PM_CLASS_LIST);
	}
	
	
	public ActionForward backPollList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		IClazzBiz icb = new ClazzBizImpl();
		IUserBiz iub = new UserBizImpl();
		
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)request.getSession().getServletContext().getAttribute(ContextKey.CLASS_POLL_MAP);
		List<TClass> classList=null;
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
		List<TUser> pmList=iub.findAllPM();
		classList=icb.getByStatus(0);
		IpollTemplateDao dao = new PollTemplateDaoImpl();
		request.setAttribute(ContextKey.CLASS_LIST, classList);
		request.setAttribute(ContextKey.PM_LIST, pmList);
		return mapping.findForward("jdt_poll_list");
	}
	

	
}
