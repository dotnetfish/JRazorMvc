package com.superstudio.web.mvc.descriptor;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

public class ControllerDescriptor {

	
	public ControllerDescriptor(Class<?> clazz){
		this.type=clazz;
		this.controllerName=clazz.getName();
		this.packagePath=clazz.getPackage().getName();
		generateActionDescriptor(clazz.getMethods());
	}
	private void generateActionDescriptor(Method[] methods) {
		// TODO Auto-generated method stub
		this.actionDescriptors=new LinkedHashSet<ActionDescriptor>();
		 for(Method method :methods){
			
			 ActionDescriptor action=new MethodActionDesriptor(this,method);
			 
			 this.actionDescriptors.add(action);
		 }
	}
	private String controllerName;

	public String getControllerName() {
		return controllerName;
	}
	
	public Class<?> getType() {
		return type;
	}

	
	public String getPackagePath() {
		return packagePath;
	}

	public Set<ActionDescriptor> getActionDescriptors() {
		return actionDescriptors;
	}

	
	private Set<ActionDescriptor> actionDescriptors;

	private Class<?> type;

	private String packagePath;
}
