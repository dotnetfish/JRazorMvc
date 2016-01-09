package com.superstudio.web.mvc.context;



import com.superstudio.web.mvc.ControllerBase;
import com.superstudio.web.mvc.RouteData;
import com.superstudio.web.webpages.DisplayModeProvider;
import com.superstudio.web.webpages.IDisplayMode;

public class ControllerContext {

	private ControllerBase controller;
	private HttpContextBase httpContext;
	private Boolean isChildAction;
	private ViewContext parentActionViewContext;
	private RequestContext requestContext;
	private RouteData routeData;

	public ControllerContext() {
	}

	protected ControllerContext(ControllerContext controllerContext) {
		this.requestContext=controllerContext.getRequestContext();
		this.httpContext=new HttpContextBase(this.requestContext.getContext());
		this.controller=controllerContext.getController();
		this.setRouteData(controllerContext.getRouteData());
	}

	public ControllerContext(RequestContext requestContext, ControllerBase controller) {
		
		this.requestContext=requestContext;
		this.httpContext=new HttpContextBase(requestContext.getContext());
		this.controller=controller;
		this.setRouteData(requestContext.getRouteData());
	}

	public ControllerContext(HttpContextBase httpContext, RouteData routeData, ControllerBase controller) {
		this.httpContext=httpContext;
		this.requestContext=new RequestContext(routeData.getRoute(),httpContext.getContext());
		this.setRouteData(routeData);
		this.controller=controller;
	};

	public ControllerBase getController() {
		return controller;
	}

	public void setController(ControllerBase controller) {
		this.controller = controller;
	}

	public Boolean isChildAction() {
		return isChildAction;
	}

	public void setChildAction(Boolean isChildAction) {
		this.isChildAction = isChildAction;
	}

	public ViewContext getParentActionViewContext() {
		return parentActionViewContext;
	}

	public void setParentActionViewContext(ViewContext parentActionViewContext) {
		this.parentActionViewContext = parentActionViewContext;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public RouteData getRouteData() {
		return routeData;
	}

	public void setRouteData(RouteData routeData) {
		this.routeData = routeData;
	}

	public HttpContextBase getHttpContext() {
		return httpContext;
	}

	public void setHttpContext(HttpContextBase httpContext) {
		this.httpContext = httpContext;
	}
	
	 public IDisplayMode getDisplayMode() {
		return DisplayModeProvider.GetDisplayMode(getHttpContext());
	}

	public void setDisplayMode(IDisplayMode displayMode) {
		DisplayModeProvider.SetDisplayMode(getHttpContext(), displayMode);
	}

	
    /* {
         get { return DisplayModeProvider.GetDisplayMode(HttpContext); }
         set { DisplayModeProvider.SetDisplayMode(HttpContext, value); }
     }*/

}
