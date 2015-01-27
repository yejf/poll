package com.tarena.poll.web.filters;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.commons.statics.ContextKey;
import com.tarena.poll.commons.xml.I18NManager;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.web.filter.HttpFilter;
/**
 * 
 * @author  zhengxh
 * @date :2009-1-9更新
 * 说明：该过滤器用户判断学生所在班级是否开启评审
 *
 */
public class CheckClassFilter extends HttpFilter {
	/*
	 * 
	 */
	private Lock lock=new ReentrantLock();
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)context.getAttribute(ContextKey.CLASS_POLL_MAP);//这里可能需要修改参数名
		
		/*
		 * 获取学生访问时的ip地址，这里分两种情况1.单机测试；2.联网测试
		 */
		String studentIp=request.getRemoteAddr();
		String stu_ip=studentIp.substring(0, studentIp.lastIndexOf("."));
		 /*
		  * 判断学生所在班级是否已经开启评审，如果有，那么把学生的ip放入record_ip_map中
		  * 在更新record_ip_map时做了加锁处理。
		  * 这里，record_ip_map使用了<String,Integer>键值对，其中，key存放学员的ip，value存放学生进入系统的次数。
		  * 为什么要这样处理？为了防止学员反复进入系统而不提交时，基地管理员页面错误显示进入系统人数增加的现象。
		  * 
		  * 当学员提交评审时，在record_ip_map中增加一个键值对，这里key时学生的ip加上字符"yes",value是1，这样在
		  * CheckReSubmitFilter中就可以以此判断学生是否提交了。
		  */
		 boolean flag=false;
		 if(class_poll_map!=null&&class_poll_map.keySet()!=null){
			 for(Object obj :class_poll_map.keySet()){
				 TClass clazz=(TClass)obj;
				 String ip=clazz.getClassIP();
			 		if(ip!=null&&ip.equals(stu_ip)){
	
			 			flag=true;
			 			//.......
			 			Map<String,Integer> record_ip_map = (Map<String,Integer>)request.getSession().getServletContext().getAttribute(ContextKey.RECORD_IP_MAP);
			 			if(record_ip_map==null){
			 				record_ip_map=new HashMap<String,Integer>();
			 				lock.lock();
			 				record_ip_map.put(studentIp, 1);
			 				lock.unlock();
			 			}else{
			 				int num=0;
			 				for(Object obj2:record_ip_map.keySet()){
			 					String s=(String)obj2;
			 					if(s.equals(studentIp)){
			 						int i=record_ip_map.get(s)+1;
			 						lock.lock();
			 						record_ip_map.put(studentIp, i);
			 						lock.unlock();
									break;
			 					}
			 					num++;
			 				}
			 				/*
			 				 * 如果record_ip_map记录中没有这个学员的记录，那么更新record_ip_map
			 				 */
			 				if(num==record_ip_map.keySet().size()){
			 					lock.lock();
			 					record_ip_map.put(studentIp, 1);
			 					lock.unlock();
			 				}
			 			}//.........

			 			request.getSession().getServletContext().setAttribute(ContextKey.RECORD_IP_MAP, record_ip_map);
			 			
			 			chain.doFilter((HttpServletRequest)request, (HttpServletResponse)response);			 
			 			break;
			 		}
			 	}
		 }
			 
		 if(!flag){				
			I18NManager m =I18NManager.getInstance().configure("config/xml/message.xml");
			String message=m.getText("message", "warn_class_nobegin");
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/global/warr.jsp");
			dispatcher.forward(request, response);
		 } 
		 
		 
	
		
	}

}
