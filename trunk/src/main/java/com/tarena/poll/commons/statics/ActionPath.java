package com.tarena.poll.commons.statics;

/**
 * poll项目各action对应的path
 * @author liuxiaofei
 *
 */
public class ActionPath {
	/**
	 * 学员填写调查前的预加载
	 */
	public static final String PRE_POLL_CONTENT = "/pre_poll_content";
	/**
	 * 学员调查信息提交按钮
	 */
	public static final String POLL_SUBMIT = "/poll_submit";
	/**
	 * 登录按钮
	 */
	public static final String LOGIN = "/login";
	/**
	 * PM与PMO退出
	 */
	public static final String LOGOUT = "/logout";
	/**
	 * PM修改密码后的跳转
	 */
	public static final String PM_CLASS_LIST = "/pm_class_list";
	/**
	 * PMO修改密码后的跳转
	 */
	public static final String PMO_UNAUDIT_LIST = "/pmo_unaudit_list";
	/**
	 *隐藏修改密码页面，避免页面暴露在外
	 */
	public static final String TO_PASSWD_MODIFY = "/to_passwd_modify";
	/**
	 * 密码修改
	 */
	public static final String PASSWD_MODIFY = "/passwd_modify";
	/**
	 * 为增加班级服务，避免jsp暴露出来
	 */
	public static final String PM_CLASS_TO_ADD = "pm_class_to_add";
	/**
	 * 增加班级
	 */
	public static final String PM_CLASS_ADD = "/pm_class_add";
	/**
	 * 查询出指定班级的信息,为修改班级信息服务
	 */
	public static final String PM_CLASS_TO_MODIFY = "/pm_class_to_modify";
	/**
	 * 修改班级
	 */
	public static final String PM_CLASS_MODIFY = "/pm_class_modify";
	/**
	 * 删除班级
	 */
	public static final String PM_CLASS_REMOVE = "/pm_class_remove";
	/**
	 * 增加的功能，按照班级名称搜索班级
	 */
	public static final String PM_CLASS_QUERY_NAME = "/pm_class_query_Name";
	/**
	 * PM激活考评
	 */
	public static final String PM_POLL_ACTIVATE = "/pm_poll_activate";
	/**
	 * 查询所有没有审核的调查
	 */
	public static final String PMO_POLL_UNAUDIT = "/pmo_poll_unaudit";
	/**
	 * 点击未审调查的明细，对应的path
	 */
	public static final String PMO_POLL_DETAIL = "/pmo_poll_detail";
	/**
	 * 点击已审调查的明细，对应的path
	 */
	public static final String PMO_POLL_AUDITED = "pmo_poll_audited";
	/**
	 * 审核按钮(超连接)对应的path
	 */
	public static final String PMO_POLL_AUDIT = "/pmo_poll_audit";
	/**
	 * 查看某个学员提交的具体调查
	 */
	public static final String PMO_POLL_LINE_DETAIL = "/pmo_poll_line_detail";
	/**
	 * 预加载查询条件，例如班级，PM，时间等等
	 */
	public static final String PMO_POLL_TO_QUERY = "/pmo_poll_to_query";
	/**
	 * 搜索按钮
	 */
	public static final String PMO_POLL_QUERY = "/pmo_poll_query";
	/**
	 * 去按月查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_M = "/pmo_poll_to_query_m";
	/**
	 * 按月去查询统计报表
	 */
	public static final String PMO_POLL_QUERY_M = "/pmo_poll_query_m";
	/**
	 * 去按季查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_Q = "/pmo_poll_to_query_q";
	/**
	 * 按季度去查询统计报表
	 */
	public static final String PMO_POLL_QUERY_Q = "/pmo_poll_query_q";
	/**
	 * 去按年查询报表页面
	 */
	public static final String PMO_POLL_TO_QUERY_Y = "/pmo_poll_to_query_Y";
	/**
	 * 按年去查询统计报表
	 */
	public static final String PMO_POLL_QUERY_Y = "/pmo_poll_query_y";
	/**
	 * 基地管理员去增加班级
	 */
	public static final String JDT_CLASS_TO_ADD = "/jdt_class_to_add";
	/**
	 * 基地管理员去修改班级信息
	 */
	public static final String JDT_CLASS_TO_MODIFY = "/jdt_class_to_modify";
	/**
	 * 基地管理员增加班级
	 */
	public static final String JDT_CLASS_ADD="/jdt_class_add";
	/**
	 * 基地管理员修改班级信息
	 */
	public static final String JDT_CLASS_MODIFY = "/jdt_class_modify";
	/**
	 * 基地帐户增加考评
	 */
	public static final String JDT_POLL_ADD = "/jdt_poll_add";
	/**
	 * 基地帐户关闭考评
	 */
	public static final String JDT_POLL_MODIFY = "/jdt_poll_modify";
	/**
	 * 基地帐户删除考评
	 */
	public static final String JDT_POLL_DELETE = "/jdt_poll_delete";
	/**
	 * 基地修改密码之后的action path
	 */
	public static final String JD_ACTIVATE_LIST = "/jd_activate_list";
	/**
	 * 为删除调查，班级回到班级列表服务
	 */
	public static final String JDT_TO_DELETE_POLL = "/jdt_to_delete_poll";

}
