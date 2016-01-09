package com.superstudio.web.mvc.context;

import com.superstudio.web.mvc.actionresult.ActionResult;
import com.superstudio.web.mvc.descriptor.ActionDescriptor;

public class AuthorizationContext extends ControllerContext {
	public AuthorizationContext() {
	}

	public AuthorizationContext(ControllerContext controllerContext, ActionDescriptor actionDescriptor) {
		super(controllerContext);
		this.setActionDescriptor(actionDescriptor);
	}

	public ActionDescriptor getActionDescriptor() {
		return actionDescriptor;
	}

	public void setActionDescriptor(ActionDescriptor actionDescriptor) {
		this.actionDescriptor = actionDescriptor;
	}

	public ActionResult getResult() {
		return result;
	}

	public void setResult(ActionResult result) {
		this.result = result;
	}

	private ActionDescriptor actionDescriptor;
	private ActionResult result;
}
