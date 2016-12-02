package com.superstudio.web.mvc.viewEngine;

import com.superstudio.jrazor.templateEngine.ViewEngineCollection;
import com.superstudio.web.mvc.actionresult.IViewEngine;

public  class ViewEngines {

	public static final ViewEngineCollection Engines = new ViewEngineCollection();;

	public static void register(IViewEngine engine){
		Engines.add(engine);
	}
}
