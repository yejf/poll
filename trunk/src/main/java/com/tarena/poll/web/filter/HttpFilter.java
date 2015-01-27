package com.tarena.poll.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
		
	}

	public void doFilter(final ServletRequest request, final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {
		doFilter((HttpServletRequest) request, (HttpServletResponse) response,
				chain);
	}

	public abstract void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException;

	public void init(final FilterConfig config) throws ServletException {
		this.config = config;
		init();
	}

	public void init() throws ServletException {

	}

	public FilterConfig getFilterConfig() {
		return config;
	}

	public String getInitParameter(final String name) {
		return config.getInitParameter(name);
	}

	public ServletContext getServletContext() {
		return config.getServletContext();
	}
}
