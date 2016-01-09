package com.superstudio.web.mvc.context;

import com.superstudio.web.mvc.actionresult.ActionResult;

public class ExceptionContext extends ControllerContext {
	private Exception exception;
	private Boolean exceptionHandled;
	private ActionResult result;

	public ExceptionContext() {

	}

	public ExceptionContext(ControllerContext controllerContext, Exception exception) {

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
