package com.poll.init;

import java.util.Date;

import org.junit.Test;

import com.tarena.poll.biz.IPollBiz;
import com.tarena.poll.biz.impl.PollBizImpl;
import com.tarena.poll.dao.IClassDao;
import com.tarena.poll.dao.IClassTypeDao;
import com.tarena.poll.dao.IPollContentDao;
import com.tarena.poll.dao.IPollDao;
import com.tarena.poll.dao.IUserDao;
import com.tarena.poll.dao.IpollTemplateDao;
import com.tarena.poll.dao.impl.ClassDaoImpl2;
import com.tarena.poll.dao.impl.ClassTypeDaoImpl;
import com.tarena.poll.dao.impl.PollContentImpl;
import com.tarena.poll.dao.impl.PollDaoImpl2;
import com.tarena.poll.dao.impl.PollTemplateDaoImpl;
import com.tarena.poll.dao.impl.UserDaoImpl2;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;
import com.tarena.poll.entity.TPollContent;
import com.tarena.poll.entity.TPollLine;
import com.tarena.poll.entity.TPollTemplate;
import com.tarena.poll.entity.TUser;

/**
 *本来用来演示
 *author datong
 */
public class InitData {
	@Test
	public void testInsertClassType(){
		TClassType type1 = new TClassType(null, "【JAVAEE】大学生实训班");
		TClassType type2 = new TClassType(null, "【Android】大学生实训班");
		TClassType type3 = new TClassType(null, "【UI】大学生实训班");
		TClassType type4 = new TClassType(null, "【嵌入式】大学生实训班");
		IClassTypeDao dao = new ClassTypeDaoImpl();
		dao.SaveType(type1);
		dao.SaveType(type2);
		dao.SaveType(type3);
		dao.SaveType(type4);
	}
	@Test
	public void testInsertPollContent(){
		TPollContent content1 = new TPollContent(null, "讲师对所授课程的整体把握程度", "授课实施",1);
		TPollContent content2 = new TPollContent(null, "讲师在授课时所做的知识点小结、重点难点总结", "授课实施",1);
		TPollContent content3 = new TPollContent(null, "讲师授课准备是否充份", "授课实施",1);
		TPollContent content4 = new TPollContent(null, "讲师对解答学员的问题是否到位、易于理解", "授课实施",1);
		TPollContent content5 = new TPollContent(null, "对教学充满热情，讲课认真、投入", "授课实施",1);
		TPollContent content6 = new TPollContent(null, "讲师有无根据大家的学习情况及时给大家做串讲和集中专题辅导", "授课实施",1);
		TPollContent content7 = new TPollContent(null, "在授课过程中，是否条理清晰、易于理解", "授课实施",1);
		TPollContent content8 = new TPollContent(null, "是否有关于学习方法方面的辅导", "授课实施",1);
		TPollContent content9 = new TPollContent(null, "有无及时、准确地解答大家的疑问和调试程序错误", "授课实施",1);
		TPollContent content10 = new TPollContent(null,"有无主动帮助大家发现并解决实现中的问题", "授课实施",1);
	
		TPollContent content11 = new TPollContent(null,"是否有效地进行提升级班学习气氛", "学习管理",1);
		TPollContent content12 = new TPollContent(null,"讲师的授课的精神面貌是否积极、主动", "学习管理",1);
		TPollContent content13 = new TPollContent(null,"讲师是否有及时对学员的反馈做出积极、正确的回应", "学习管理",1);
		TPollContent content14 = new TPollContent(null,"能否经常与大家相互沟通,了解大家的想法、需求", "学习管理",1);
		TPollContent content15 = new TPollContent(null,"能否维持良好的班级学习气氛", "学习管理",1);
		TPollContent content16 = new TPollContent(null,"严格要求学生，其言传身教有助于学生治学与做人", "学习管理",1);
		TPollContent content17 = new TPollContent(null,"教师管理", "问题",1);
		TPollContent content18 = new TPollContent(null,"学习管理", "问题",1);
		

		IPollContentDao dao = new PollContentImpl();
		dao.savePollContent(content1);
		dao.savePollContent(content2);
		dao.savePollContent(content3);
		dao.savePollContent(content4);
		dao.savePollContent(content5);
		dao.savePollContent(content6);
		dao.savePollContent(content7);
		dao.savePollContent(content8);
		dao.savePollContent(content9);
		dao.savePollContent(content10);
		dao.savePollContent(content11);
		dao.savePollContent(content12);
		dao.savePollContent(content13);
		dao.savePollContent(content14);
		dao.savePollContent(content15);
		dao.savePollContent(content16);
		dao.savePollContent(content17);
		dao.savePollContent(content18);
	}
	@Test
	public void testInsertUser(){
		TUser user1 =new TUser("周萍", "888888", "班主任", 2, 0);
		TUser user3 =new TUser("tqmo", "qazwsx", "超级管理员", 1, 0);
		IUserDao dao = new UserDaoImpl2();
		dao.saveUser(user1);
		dao.saveUser(user3);
	}
	
	
}
