package com.superstudio.web.mvc.context;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpRequestBase {

	private HttpServletRequest request;

	public HttpRequestBase(HttpServletRequest request) {
		this.request = request;

	}

	public String mapPath(String vp) {

		return request.getServletContext().getRealPath(vp);
	}

	public String getRealPath(String string) {

		return request.getServletContext().getRealPath(string);
	}

	public String getRequestURI() {

		return request.getRequestURI();
	}

	public CharSequence getServletPath() {

		return request.getServletPath();
	}

	public Cookie[] getCookies() {

		return request.getCookies();
	}

	public Map<String, ?> getParameterMap() {

		return request.getParameterMap();
	}

	public String getHeader(String headerName) {

		return request.getHeader(headerName);
	}
}
