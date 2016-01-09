package com.superstudio.web.mvc.context;

import java.util.ArrayList;
import java.util.List;

import com.superstudio.web.mvc.descriptor.ControllerDescriptor;

public class ControllerCache {
	public static List<ControllerDescriptor> controllers= new ArrayList<ControllerDescriptor>();
	
	public static void add(ControllerDescriptor clazz){
		controllers.add(clazz);
	}
	
	public static List<ControllerDescriptor> getController(String name){
		List<ControllerDescriptor> result=new ArrayList<ControllerDescriptor>();
		for(ControllerDescriptor controller:controllers){
			if(controller.getControllerName().toLowerCase().endsWith(name.toLowerCase()+"controller")){
				result.add(controller);
			}
		}
		return result;
	}
}
