package com.tarena.poll.commons.statics;

public class ContextKey {
	/**
	 * 存放当前登录用户的信息
	 */
	public static final String CURRENT_USER = "currentUser";

	/**
	 * 所有未审核列表
	 */
	public static final String UNAUDIT_POLL_LIST = "unauditPollList";

	/**
	 * 班级列表
	 */
	public static final String CLASS_LIST = "classList";

	/**
	 * PM列表
	 */
	public static final String PM_LIST = "pmList";

	/**
	 * 调查列表
	 */
	public static final String POLL_LIST = "pollList";

	/**
	 * 年
	 */
	public static final String YEAR = "year";

	/**
	 * 月
	 */
	public static final String MONTH = "month";

	/**
	 * 存放所有报表
	 */
	public static final String GROUP_BY_PM = "groupByPM";

	/**
	 * 季度
	 */
	public static final String QUARTER = "quarter";

	/**
	 * 按照条件查询到的调查
	 */
	public static final String POLL_QUERY = "pollQuery";

	/**
	 * 调查详情
	 */
	public static final String POLL_LINE_DETAIL = "pollLineDetail";

	/**
	 * 查看TPollLine
	 */
	public static final String POLL_LINE = "pollLine";

	/**
	 * 一条未审的Statistics信息
	 */
	public static final String UNAUDIT = "unaudit";

	/**
	 * 某个调查对应的详细信息
	 */
	public static final String POLL_LINES = "pollLines";

	/**
	 * 一条已审的Statistics信息
	 */
	public static final String AUDITED = "audited";

	/**
	 * 存放所有已激活的调查
	 */
	public static final String CLASS_POLL_MAP = "class_poll_map";

	/**
	 * 当前PM
	 */
	public static final String CURRENT_PM = "currentPm";

	/**
	 * 当前班级
	 */
	public static final String CURRENT_CLAZZ = "currentClazz";

	/**
	 * 防止用户重新考评
	 */
	public static final String RECORD_IP_MAP = "record_ip_map";

	/**
	 * 根据ID查到的班级
	 */
	public static final String CLASS_BY_ID = "clazzById";

	/**
	 * 根据班级名称查到的班级
	 */
	public static final String CLAZZS = "clazzs";

	/**
	 * 班级列表
	 */
	public static final String CLAZZID = "clazzId";

	/***************************************************************************
	 * 从pm_content.xml中读取的对PM教学管理的考评
	 */
	public static final String _SKILLS = "_SKILLS";

	/***************************************************************************
	 * 从pm_content.xml中读取的对PM学员管理的考评
	 */
	public static final String _SERVICES = "_SERVICES";

	/***************************************************************************
	 * 从pm_content.xml中读取的对PM的其他考评指标
	 */
	public static final String _OTHERS = "_OTHERS";
	
	/****************************************************************************
	 * 从pm_content.xml 配置文件中读取的 问题反馈 指标 KEY 值 ， 范围：application
	 */
	public static final String _QUESTIONS = "_QUESTIONS";
	
	/**************************
	 * 班级类型
	 */
	public static final String CLASS_TYPES = "CLASS_TYPES";
	
}


