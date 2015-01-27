package com.tarena.poll.commons.statics;

public class ForwardPath {
	
	/**
	 * 预加载调查信息后的跳转路径名称
	 */
	public static final String PRE_POLL_CONTENT = "pre_poll_content";
	/**
	 * 调查没有激活或者已经调查过，调转的路径名称
	 */
	public static final String WARNING = "warning";
	/**
	 * 点击提交按钮调转的路径
	 */
	public static final String POLL_SUBMIT = "poll_submit";
	/**
	 * 登录失败跳转的路径
	 */
	public static final String LOGIN_FAIL = "login_fail";
	/**
	 * PM登录成功跳转的路径
	 */
	public static final String PM_LOGIN_SUCCESS = "pm_login_success";
	/**
	 * JD登录成功跳转的路径
	 */
	public static final String JD_LOGIN_SUCCESS = "jd_login_success";
	/**
	 * PMO登录成功跳转的路径
	 */
	public static final String PMO_LOGIN_SUCCESS = "pmo_login_success";
	/**
	 * 退出跳转的路径
	 */
	public static final String LOGOUT = "logout";
	/**
	 * 点击修改密码按钮跳转的路径，避免JSP页面暴露在外面
	 */
	public static final String TO_PASSWD_MODIFY = "to_passwd_modify";	
	/**
	 * 修改密码后跳转的页面
	 */
	public static final String PASSWD_MODIFY = "passwd_modify";
	/**
	 * 经过jump.jsp转发，PM修改密码之后跳转的路径
	 */
	public static final String PM_CLASS_LIST = "pm_class_list";
	/**
	 * 经过jump.jsp转发，PMO修改密码之后跳转的路径
	 */
	public static final String PMO_UNAUDIT_LIST = "pmo_unaudit_list";
	/**
	 * 基地管理员帐号点击增加班级按钮跳转的路径，避免JSP页面暴露在外面
	 */
	public static final String JDT_CLASS_TO_ADD = "jdt_class_to_add";
	
	/**
	 * 点击增加班级按钮跳转的路径，避免JSP页面暴露在外面
	 */
	public static final String PM_CLASS_TO_ADD = "pm_class_to_add";
	/**
	 * JDT增加班级
	 */
	public static final String JDT_CLASS_ADD = "jdt_class_add";
	/**
	 * PM增加班级
	 */
	public static final String PM_CLASS_ADD = "pm_class_add";
	/**
	 * 基地班级转去修改班级页面
	 */
	public static final String JDT_CLASS_TO_MODIFY = "jdt_class_to_modify";
	/**
	 * 点击修改班级按钮时，跳转的路径，真正修改之前去根据指定信息
	 * 去查询班级信息，为修改服务
	 */
	public static final String PM_CLASS_TO_MODIFY = "pm_class_to_modify";
	/**
	 * PM点击修改班级信息页面中的提交按钮所跳转的路径
	 */
	public static final String PM_CLASS_MODIFY = "pm_class_modify";
	/**
	 * JD点击修改班级信息页面中的提交按钮所跳转的路径
	 */
	public static final String JDT_CLASS_MODIFY = "jdt_class_modify";
	/**
	 * 删除班级按钮对应的跳转路径
	 */
	public static final String PM_CLASS_REMOVE = "pm_class_remove";
	/**
	 * 按班级名称查询班级对应的跳转路径
	 */
	public static final String PM_CLASS_QUERY_NAME = "pm_class_query_name";
	/**
	 * 激活考评所要跳转的路径
	 */
	public static final String PM_POLL_ACTIVATE = "pm_poll_activate";
	/**
	 * 点击审核调查所要跳转的路径
	 */
	public static final String PMO_POLL_UNAUDIT = "pmo_poll_unaudit";
	/**
	 * 点击未审调查的明细按钮，所要跳转的路径
	 */
	public static final String PMO_POLL_DETAIL = "pmo_poll_detail";
	/**
	 * 点击审核按钮要跳转的路径
	 */
	public static final String PMO_POLL_AUDIT = "pmo_poll_audit";
	/**
	 * 点击查看要跳转的路径，这里的查看，指的是要查看某个学生提交的调查
	 * 具体信息
	 */
	public static final String PMO_POLL_LINE_DETAIL = "pmo_poll_line_detail";
	/**
	 * 点击已审调查的明细按钮，所要跳转的路径
	 */
	public static final String PMO_POLL_AUDITED = "pmo_poll_audited";
	/**
	 * 点击搜索调查按钮对应的跳转路径，预加载一些调查条件
	 */
	public static final String PMO_POLL_TO_QUERY = "pmo_poll_to_query";
	/**
	 * 搜索按钮对应的调转路径
	 */
	public static final String PMO_POLL_QUERY = "pmo_poll_query";
	/**
	 * 按月查询统计报表对应的路径
	 */
	public static final String PMO_POLL_QUERY_M = "pmo_poll_query_m";
	/**
	 * 按季查询统计报表对应的路径
	 */
	public static final String PMO_POLL_QUERY_Q = "pmo_poll_query_q";
	/**
	 * 按年查询统计报表对应的路径
	 */
	public static final String PMO_POLL_QUERY_Y = "pmo_poll_query_y";
	/**
	 * 基地增加考评
	 */
	public static final String JDT_POLL_ADD = "jdt_poll_add";
	/**
	 * 基地关闭考评
	 */
	public static final String JDT_POLL_MODIFY = "jdt_poll_modify";
	/**
	 * 基地删除考评
	 */
	public static final String JDT_POLL_DELETE = "jdt_poll_delete";
	/**
	 * 去按月查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_M = "pmo_poll_to_query_m";
	/**
	 * 去按季查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_Q = "pmo_poll_to_query_q";
	/**
	 * 去按月查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_Y = "pmo_poll_to_query_y";
	/**
	 * 基地修改密码之后要调到的页面
	 */
	public static final String JD_ACTIVATE_LIST = "jd_activate_list";
	/**
	 * 页面刷新
	 */
	public static final String JDT_POLL_SHOW="jdt_poll_show";
	/**
	 * 学生评审提交失败
	 */
	public static final String SUBMIT_POLL_FAIL="submit_poll_fail";
	/**
	 * 修改密码失败
	 *@author  郑小虎
	 */
	public static final String PASSWD_MODIFY_FAIL= "passwd_modify_fail";
	/**
	 * 删除调查，班级回到班级列表
	 */
	public static final String JDT_TO_DELETE_POLL = "jdt_to_delete_poll";
	/**
	 * 结束调查，班级回到班级列表
	 */
	public static final String JDT_TO_CLOSE_POLL="jdt_to_close_poll";
	/**
	 * pmo页面下拉框点击重置密码
	 */
	public static final String TO_PASSWD_RESET="to_passwd_reset";
	/**
	 * pmo点击重置密码按钮
	 */
	public static final String PASSWD_RESET="passwd_reset";
	
	
	public static final String TO_ADD_CLASSTYPE = "to_add_classtype";
	public static final String ADD_CLASSTYPE = "add_classtype";
	public static final String ADD_CLASSTYPE_FAIL = "add_classtype_fail";
	public static final String TO_TEACHER_MANAGE = "to_teacher_manage";
	public static final String ADD_TEACHER = "add_teacher";
	public static final String DELETE_TEACHER = "delete_teacher";
	public static final String TO_TEMPLATE_MANAGE = "to_template_manage";
	public static final String ADD_CONTENT = "add_content";
	public static final String ADD_SUCCESS = "add_success";
	public static final String ADD_FAIL = "add_fail";
	public static final String TO_CONTENT_MENAGE = "to_content_manage";
}
