package com.superstudio.web.mvc.filter;

import com.superstudio.web.mvc.context.ActionExecutedContext;
import com.superstudio.web.mvc.context.ActionExecutingContext;

public interface IActionFilter {
	
	 void onActionExecuted(ActionExecutedContext filterContext);
	 
     void onActionExecuting(ActionExecutingContext filterContext);
}
