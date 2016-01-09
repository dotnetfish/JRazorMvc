package com.superstudio.web.mvc.context;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpContext {
	private static ThreadLocal<HttpContext> threadLocalRequestContext;

	public static HttpContext getCurrent() throws Exception {

		if (threadLocalRequestContext == null) {
			throw new Exception("HttpContext尚未初始化。");
		}
		return (HttpContext) threadLocalRequestContext.get();
	}

	public static HttpContext initRequestContext(HttpServletRequest request, HttpServletResponse response) {

		if (threadLocalRequestContext == null) {
			threadLocalRequestContext = new ThreadLocal<HttpContext>();
		}
		HttpContext context = new HttpContext(request, response);
		threadLocalRequestContext.set(context);
		return context;
	}

	private HttpRequestBase request;
	private HttpResponseBase response;

	private HttpContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = new HttpRequestBase(request);
		this.response = new HttpResponseBase(response);
		items=new HashMap<Object,Object>();
	}

	public HttpRequestBase getRequest() {
		return request;
	}

	public HttpResponseBase getResponse() {
		return response;
	}

	public Map<Object, Object> getItems() {
		return items;
	}

	public void setItems(Map<Object, Object> items) {
		this.items = items;
	}

	private Map<Object, Object> items;
	
	public HttpServerUtilityBase getServer() {
		
		return null;
	}

	public HttpSessionStateBase getSession() {
		
		return null;
	}

	public HttpApplicationStateBase getApplication() {
		
		return null;
	}

	public boolean IsDebuggingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
