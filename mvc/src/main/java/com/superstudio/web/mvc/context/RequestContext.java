package com.superstudio.web.mvc.context;


import com.superstudio.web.mvc.Route;
import com.superstudio.web.mvc.RouteData;

public class RequestContext {
	
	/*private static String requestContextKey="_RequestContextKey_";
	private static ThreadLocal<RequestContext> threadLocalRequestContext;
	*/
	/*public static RequestContext getCurrent() throws Exception{
		
		if(threadLocalRequestContext==null){
			throw new Exception("RequestContext尚未初始化。");
		}
		return (RequestContext)threadLocalRequestContext.get();
	}
	*/
	/*public static  RequestContext initRequestContext(Route route,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		if(threadLocalRequestContext==null){
			threadLocalRequestContext=new ThreadLocal<RequestContext>();
		}
		RequestContext context=new RequestContext(route,request,response);
		threadLocalRequestContext.set(context);
		return context;
	}
	*/
	private HttpRequestBase request;
	private HttpResponseBase response;
	private Route route;
	
	private RouteData routeData;
	
	private HttpContext context;
	public RequestContext(Route route,HttpContext context){
		this.context=context;
		this.request=context.getRequest();
		this.response=context.getResponse();
		this.routeData=new RouteData(route,context.getRequest());
	}
	
	public RequestContext(Route route,HttpRequestBase request,HttpResponseBase response) throws Exception{
		this.request=request;
		this.response=response;
		this.route=route;
		this.routeData=new RouteData(route,request);
	}

	public HttpRequestBase getRequest() {
		return request;
	}

	

	public HttpResponseBase getResponse() {
		return response;
	}

	

	public Route getRoute() {
		return route;
	}

	

	public RouteData getRouteData() {
		return routeData;
	}

	public void setRouteData(RouteData routeData) {
		this.routeData = routeData;
	}

	public HttpContext getContext() {
		return context;
	}

	public void setContext(HttpContext context) {
		this.context = context;
	}
}
