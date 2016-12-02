package com.superstudio.web.mvc.context;

import java.util.Map;

import com.superstudio.web.mvc.actionresult.ActionResult;
import com.superstudio.web.mvc.descriptor.ActionDescriptor;

public class ActionExecutingContext extends ControllerContext {

	private ActionDescriptor actionDescriptor;
	
	private Map<String, Object> actionParameters;
	private ActionResult result;

	public ActionExecutingContext() {

	}

	public ActionExecutingContext(ControllerContext controllerContext, ActionDescriptor actionDescriptor,
			Map<String, Object> actionParameters) {
		super(controllerContext);
		this.actionDescriptor = actionDescriptor;
		this.actionParameters = actionParameters;

	}

	public ActionResult getResult() {
		return result;
	}

	public void setResult(ActionResult result) {
		this.result = result;
	}

	public ActionDescriptor getActionDescriptor() {
		return actionDescriptor;
	}

	public void setActionDescriptor(ActionDescriptor actionDescriptor) {
		this.actionDescriptor = actionDescriptor;
	}

	public Map<String, Object> getActionParameters() {
		return actionParameters;
	}

	public void setActionParameters(Map<String, Object> actionParameters) {
		this.actionParameters = actionParameters;
	}

}
