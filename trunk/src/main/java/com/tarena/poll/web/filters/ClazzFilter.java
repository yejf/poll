package com.tarena.poll.web.filters;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TPoll;
import com.tarena.poll.web.filter.HttpFilter;
public class ClazzFilter extends HttpFilter{
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		   
	}

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session=((HttpServletRequest)request).getSession();
		ServletContext context=session.getServletContext();
		Map<TClass,TPoll> class_poll_map=(Map<TClass,TPoll>)context.getAttribute("class_poll_map");//这里可能需要修改参数名

		/*
		 * 获取学生访问时的ip地址，这里分两种情况1.单机测试；2.联网测试
		 */
		 String studentIp=InetAddress.getLocalHost().getHostAddress();//这里是单机测试
		 String[] ips=studentIp.split("\\.");
//		 String studentIp=request.getLocalAddr();
//		 String[] ips=request.getLocalAddr().split("\\.");  //这里是联网测试

		 StringBuffer sb=new StringBuffer();
		 sb.append(ips[0]);
		 sb.append(".");
		 sb.append(ips[1]);
		 sb.append(".");
		 sb.append(ips[2]);
		 
		 String stu_ip=sb.toString();
		 Map<String,Integer>record_ip_map=(Map<String,Integer>)((HttpServletRequest)request).getSession().getServletContext().getAttribute("record_ip_map");
		 if(record_ip_map==null){
			 record_ip_map=new HashMap<String,Integer>();
			 ((HttpServletRequest)request).getSession().getServletContext().setAttribute("record_ip_map", record_ip_map);
		 }
		 //.....
//		 Set<String>record_ip_set=(Set<String>)((HttpServletRequest)request).getSession().getServletContext().getAttribute("record_ip_set");
//		 if(record_ip_set==null){
//			 record_ip_set=new HashSet<String>();
//			 ((HttpServletRequest)request).getSession().getServletContext().setAttribute("record_ip_set", record_ip_set);
//		 }
		//.......
		 /*
		  * 判断学生是否已评审过，在application中方一个集合存放学员的ip，以此判断
		  */
		 if(class_poll_map!=null&&!(record_ip_map.keySet().contains(studentIp))){
			 for(Object obj :class_poll_map.keySet()){
			 TClass clazz=(TClass)obj;
			 String ip=clazz.getClassIP();
			 	if(ip!=null&&ip.equals(stu_ip)){
			 		record_ip_map.put(studentIp,1);//这里将学生的ip放入集合中，记录下来，并且更新上下文
			 		((HttpServletRequest)request).getSession().getServletContext().setAttribute("record_ip_map", record_ip_map);
			 		                                                                             
				 chain.doFilter((HttpServletRequest)request, (HttpServletResponse)response);			 
				
			 	}
			 }
		 }
		 if(record_ip_map.keySet().contains(studentIp)){
			 ((HttpServletRequest)request).getSession().setAttribute("message", "对不起，你已经评审过了");
			 ((HttpServletResponse)response).sendRedirect("/poll/global/warr.jsp");
	 
		 }else{
			 ((HttpServletRequest)request).getSession().setAttribute("message", "对不起，你的班级还没有开始评审");
			 ((HttpServletResponse)response).sendRedirect("/poll/global/warr.jsp");
		 }
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		init();	
	}

}
