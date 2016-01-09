package com.superstudio.web.mvc.context;

import java.util.Map;

public class HttpContextBase  {

	private HttpContext context;
	
	public HttpContext getContext(){
		return context;
	}
	public HttpContextBase(HttpContext httpContext) {
		// TODO Auto-generated constructor stub
		this.context=httpContext;
	}
	private HttpRequestBase request;
	private HttpResponseBase response;

	

	public HttpRequestBase getRequest() {
		return context.getRequest();
	}

	public HttpResponseBase getResponse() {
		return context.getResponse();
	}

	public Map<Object, Object> getItems() {
		return context.getItems();
	}

	public void setItems(Map<Object, Object> items) {
		context.setItems(items);
	}

	
	
	public HttpServerUtilityBase getServer() {
		
		return context.getServer();
	}

	public HttpSessionStateBase getSession() {
		
		return context.getSession();
	}

	public HttpApplicationStateBase getApplication() {
		
		return context.getApplication();
	}

	public Browser GetOverriddenBrowser() {
		// TODO Auto-generated method stub
		return new Browser();
	}
}
