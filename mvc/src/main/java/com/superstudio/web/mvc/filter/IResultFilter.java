package com.superstudio.web.mvc.filter;

import com.superstudio.web.mvc.context.ResultExecutedContext;
import com.superstudio.web.mvc.context.ResultExecutingContext;

public interface IResultFilter {
	void onResultExecuted(ResultExecutedContext filterContext);
    void onResultExecuting(ResultExecutingContext filterContext);
}
