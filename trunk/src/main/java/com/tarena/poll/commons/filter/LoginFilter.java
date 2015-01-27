package com.tarena.poll.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.commons.statics.ContextKey;

/**
 * The Class LoginFilter. Check user whether if login。
 * 
 * PGMS encodingfilter.
 * 
 */
public class LoginFilter implements Filter {
	private FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String url = request.getServletPath();
		LogOutPut.getInstance().warn("URL=[ " + url + " ]！");
		if (url.indexOf("index.jsp") != -1 || url.indexOf("login") != -1
				|| url.indexOf("logout") != -1
				|| url.indexOf("poll_content") != -1
				|| url.indexOf("result") != -1
				|| url.indexOf("error") != -1
				|| url.indexOf("warr") != -1
				|| url.indexOf("jdt_poll_show") != -1
				|| url.indexOf("poll_submit") != -1) {
			if(url.indexOf("/jdmanager/poll_content.jsp")==-1){
				chain.doFilter(request, response);
				return;
			}
			
		}
		if (session == null) {
			LogOutPut.getInstance()
					.warn("session is null，URL=[ " + url + " ]！");
			request.getRequestDispatcher("/admin/index.jsp").forward(request,
					response);
		} else {
			if (session.getAttribute(ContextKey.CURRENT_USER) == null) {
				request.getRequestDispatcher("/admin/index.jsp").forward(
						request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void destroy() {
	}
}
