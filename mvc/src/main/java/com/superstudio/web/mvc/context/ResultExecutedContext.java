package com.superstudio.web.mvc.context;

import com.superstudio.web.mvc.actionresult.ActionResult;

public class ResultExecutedContext extends ControllerContext {
	
	private ControllerContext controllerContext;
	private Boolean canceled;
	private Exception exception;
	private Boolean exceptionHandled;
	private ActionResult result;
	
	public ResultExecutedContext() {
	}

	public ResultExecutedContext(ControllerContext controllerContext, ActionResult result, Boolean canceled,
			Exception exception) {
		super(controllerContext);
		this.controllerContext = controllerContext;
		this.result = result;
		this.canceled = canceled;
		this.exception = exception;
	}

	public Boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Boolean getExceptionHandled() {
		return exceptionHandled;
	}

	public void setExceptionHandled(Boolean exceptionHandled) {
		this.exceptionHandled = exceptionHandled;
	}

	public ActionResult getResult() {
		return result;
	}

	public void setResult(ActionResult result) {
		this.result = result;
	}

	
}
