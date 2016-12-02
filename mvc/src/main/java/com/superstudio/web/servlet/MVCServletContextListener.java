package com.superstudio.web.servlet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.superstudio.web.mvc.Route;
import com.superstudio.web.mvc.descriptor.ControllerDescriptor;
import com.superstudio.commons.reflactor.annotations.ClassFilter;
import com.superstudio.commons.reflactor.annotations.ClassScanner;
import com.superstudio.jrazor.templateEngine.RazorViewEngine;
import com.superstudio.web.mvc.Controller;
import com.superstudio.web.mvc.Routes;
import com.superstudio.web.mvc.context.ControllerCache;
import com.superstudio.web.mvc.viewEngine.ViewEngines;

public class MVCServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//扫描所有的 class
		Set<Class<?>> calsses=ClassScanner.getClasses("com",new ClassFilter(){

			@Override
			public Boolean test(Class<?> calzz) {
				
				return calzz.isAssignableFrom(Controller.class);
			}
			
		});
		for(Class<?> clazz:calsses){
			ControllerDescriptor controllerDecriptor=new ControllerDescriptor(clazz);
			
			ControllerCache.add(controllerDecriptor);
		}
		
		Route route = new Route() ;
		route.setArea("");
		route.setName("default");
		route.setUri("/{controller}/{action}.html");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("controller", "home");
		map.put("action", "index");
		route.setParameters(map);
		Route route2 = new Route();
		route2.setArea("admin");
		route2.setName("defaultAdmin");
		route2.setUri("/admin/{controller}/{action}.html");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("controller", "home");
		map2.put("action", "index");
		route2.setParameters(map2);
		try {
			Routes.mapRoute(route);
			Routes.mapRoute(route2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//registe viewEngine
	//	IDependy
		//IViewPageActivator activator=new DefaultViewPageActivator();
		
		RazorViewEngine viewEngine=new RazorViewEngine();
		
		ViewEngines.register(viewEngine);
	}

}
