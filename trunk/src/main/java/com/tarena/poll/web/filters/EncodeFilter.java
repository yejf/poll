package com.tarena.poll.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.poll.web.filter.HttpFilter;

 public class EncodeFilter extends HttpServlet implements Filter{

		/** The config. */
		private FilterConfig config = null;

		/** The encoding. */
		private String encoding = "";

		/* (non-Javadoc)
		 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
		 */
		public void init(FilterConfig config) throws ServletException {
			this.config = config;
			this.encoding = config.getInitParameter("encoding");
		}

		/* (non-Javadoc)
		 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
		 */
		public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			response.setCharacterEncoding(this.encoding);
			request.setCharacterEncoding(this.encoding);
			chain.doFilter(req, res);
		}

}
