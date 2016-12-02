package com.superstudio.web.mvc.actionresult;

import java.io.IOException;

import com.superstudio.commons.exception.ArgumentNullException;
import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.web.mvc.IView;

public interface IViewEngine {
	 ViewEngineResult findPartialView(ControllerContext controllerContext, String partialViewName, boolean useCache) throws ArgumentNullException, InstantiationException, IllegalAccessException, ClassNotFoundException, Exception;
     ViewEngineResult findView(ControllerContext controllerContext, String viewName, String masterName, boolean useCache) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ArgumentNullException, Exception;
     void releaseView(ControllerContext controllerContext, IView view) throws IOException;
}
