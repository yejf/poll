package com.tarena.poll.web.filters;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitFilter implements Filter{

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Map<String,Integer>record_ip_map=(Map<String,Integer>)((HttpServletRequest)request).getSession().getServletContext().getAttribute("record_ip_map");
			/*
			 * 获取学生访问时的ip地址，这里分两种情况1.单机测试；2.联网测试
			 */
			 String studentIp=InetAddress.getLocalHost().getHostAddress();//这里是单机测试
			 String[] ips=studentIp.split("\\.");
//			 String studentIp=request.getLocalAddr();
//			 String[] ips=request.getLocalAddr().split("\\.");  //这里是联网测试

			 StringBuffer sb=new StringBuffer();
			 sb.append(ips[0]);
			 sb.append(".");
			 sb.append(ips[1]);
			 sb.append(".");
			 sb.append(ips[2]);
			 
			 String stu_ip=sb.toString();
			 String mark=null;
			 boolean flag=false;
			 for(Object obj:record_ip_map.keySet()){
				 String key=(String)obj;
				 if(key.equals(studentIp)){
					 if(record_ip_map.get(key)==1){
						 mark=key;
					 }
					 if(record_ip_map.get(key)==2){
						 flag=true;
					 }
				 }
				 
				 if(mark!=null){
					 record_ip_map.put(mark, 2);
				 }		 
				 if(!flag){
					 chain.doFilter((HttpServletRequest)request, (HttpServletResponse)response);
					 
				 }else{
					 ((HttpServletRequest)request).getSession().setAttribute("message", "对不起，你已经评审过了");
					 ((HttpServletResponse)response).sendRedirect("/poll/global/warr.jsp");
				 }
			 }

		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
