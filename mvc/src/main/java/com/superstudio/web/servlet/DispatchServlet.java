package com.superstudio.web.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.superstudio.web.mvc.ControllerBase;
import com.superstudio.web.mvc.Route;
import com.superstudio.web.mvc.actionresult.ActionResult;
import com.superstudio.web.mvc.context.ControllerCache;
import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.web.mvc.descriptor.ControllerDescriptor;
import com.superstudio.web.HttpContext;
import com.superstudio.web.mvc.Routes;
import com.superstudio.web.mvc.context.RequestContext;
import com.superstudio.web.mvc.descriptor.ActionDescriptor;

import javax.servlet.http.*;

public class DispatchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpContext context=HttpContext.initRequestContext(request, response);
		String uri=request.getServletPath();
		List<Route> routeMatched=Routes.Match(uri);
		if(routeMatched.size()==1){
			try {
				
				//(request,response);
				RequestContext requestContext=new RequestContext(routeMatched.get(0),context);
				String actionName=requestContext.getRouteData().getAction();
				String controllerName=requestContext.getRouteData().getController();
				List<ControllerDescriptor> controllers= ControllerCache.getController(controllerName);
				List<ActionDescriptor> actions=new ArrayList<ActionDescriptor>();
				for(ControllerDescriptor controller :controllers){
					controller.getActionDescriptors().forEach((item)->{
						if(item.getActionName().toLowerCase().endsWith(actionName.toLowerCase())){
							actions.add(item);
						}
					});
				}
				if(actions.size()==1){
					ActionDescriptor action=actions.get(0);
					//TODO controllerBuilderFactory to create a controller instance
					ControllerBase controller=(ControllerBase)action.getControllerDescriptor().getType().newInstance();
					controller.Initialize(requestContext);
						ControllerContext controllerContext=new ControllerContext(requestContext,controller);
					//((ControllerBase)context).i
					
					Map<String, Object> parameters = null;
					Object actionResult=action.Execute(controllerContext, parameters);
					if(actionResult instanceof ActionResult){
						ActionResult result=(ActionResult)actionResult;
						result.Execute(controllerContext);
					}else{
						if(actionResult!=null){
							response.getWriter().write(actionResult.toString());
						}
						
					}
				}else{
					
				}
				/*response.getWriter().write(RequestContext.getCurrent().getRouteData().getName());
				response.getWriter().write("<br/>---------1--------<br/>");
				response.getWriter().write(RequestContext.getCurrent().getRouteData().getController());
				response.getWriter().write("<br/>---------2--------<br/>");
				response.getWriter().write(RequestContext.getCurrent().getRouteData().getName());*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(routeMatched.size()==0){
				throw new IOException("未找到匹配的路邮配置。");
			}
			if(routeMatched.size()>0){
				throw new IOException("重复的的路邮配置。");
			}
		}
		
		
	}
}
