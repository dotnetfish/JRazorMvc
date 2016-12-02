package com.superstudio.web.mvc.descriptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import com.superstudio.web.mvc.context.ControllerContext;

public abstract class ActionDescriptor {
	protected ActionDescriptor() {
	}

	private String actionName;

	public String getActionName() {
		return this.actionName;
	}
	
	protected void setActionName(String actionName) {
		 this.actionName=actionName;
	}

	private ControllerDescriptor controllerDescriptor;

	public ControllerDescriptor getControllerDescriptor() {
		return this.controllerDescriptor;
	}
	
	protected void setControllerDescriptor(ControllerDescriptor desc) {
		 this.controllerDescriptor=desc;
	}

	private String uniqueId;

	public String getUniqueId() {
		return this.uniqueId;
	}

	public abstract Object execute(ControllerContext controllerContext, Map<String, Object> parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException;

	public Object[] getCustomAttributes(Boolean inherit) {
		return null;
	}

	public Object[] getCustomAttributes(Class attributeType, Boolean inherit) {
		return null;
	}

	public abstract ParameterDescriptor[] getParameters();

	public Collection<ActionSelector> getSelectors() {
		return null;
	}

	public Boolean isDefined(Class attributeType, Boolean inherit) {
		return null;
	}
}
