package com.superstudio.web.mvc.filter;

import com.superstudio.web.mvc.context.ExceptionContext;

public interface IExceptionFilter {
	void onException(ExceptionContext filterContext);
}
