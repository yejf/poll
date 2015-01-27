package com.tarena.poll.web.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.xml.I18NManager;

public class PreLoadListener implements ServletContextListener {

	/*******************************
	 * 释放资源
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		
		LogOutPut.getInstance().debug("shutdown the server, begin to release resources...");
		/* 释放连接池 */
		//DBPool.getInstance().releaseAll();
		
		/* 清除application范围中的数据 */
		sce.getServletContext().removeAttribute(ContextKey.CLASS_POLL_MAP);
		sce.getServletContext().removeAttribute(ContextKey._SKILLS);
		sce.getServletContext().removeAttribute(ContextKey._SERVICES);
		sce.getServletContext().removeAttribute(ContextKey._OTHERS);
		sce.getServletContext().removeAttribute(ContextKey.RECORD_IP_MAP);
		LogOutPut.getInstance().debug("release resource successful . . .,The server was shutdown over.");
	}

	public void contextInitialized(ServletContextEvent sce) {
		I18NManager i18n = I18NManager.getInstance();
		i18n.configure("config/xml/pm_content.xml");
		/* 获取 "对项目经理的评审项" 考核指标; 并绑定到 指定KEY上, 范围为 application */
		Map skill_map = i18n.getEntry("_skills");
		sce.getServletContext().setAttribute(ContextKey._SKILLS, skill_map);
		
		/* 获取 "对实训服务的考评" 考核指标; 并绑定到 指定 KEY上，范围为 application */
		Map service_map = i18n.getEntry("_services");
		sce.getServletContext().setAttribute(ContextKey._SERVICES, service_map);
		
		/* 获取 "其它" 考核指标; 并绑定到 指定 KEY上，范围为 application */
		Map other_map = i18n.getEntry("_others");
		sce.getServletContext().setAttribute(ContextKey._OTHERS, other_map);
		
		/* 获取 "问题反馈"  */
		Map question_map = i18n.getEntry("_questions");
		sce.getServletContext().setAttribute(ContextKey._QUESTIONS, question_map);
		
		/* 加载班级类型 */
		i18n.configure("config/xml/class_type.xml");
		Map classType_map = i18n.getEntry("class_type");
		sce.getServletContext().setAttribute(ContextKey.CLASS_TYPES, classType_map);
		
		/** 在内存中设置用户与其邮箱的对应关系 */
		
	}

}




