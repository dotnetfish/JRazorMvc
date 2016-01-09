package com.superstudio.web.mvc.context;

import com.superstudio.web.mvc.actionresult.ActionResult;
import com.superstudio.web.mvc.descriptor.ActionDescriptor;


public class ActionExecutedContext extends ControllerContext {
	
	private ActionDescriptor actionDescriptor;
	private Boolean canceled =false;
    private  Exception exception;
    private Boolean exceptionHandled=false;
    private ActionResult result ;
	
	public ActionExecutedContext(){
		
	}
    public ActionExecutedContext(ControllerContext controllerContext, 
    		ActionDescriptor actionDescriptor, Boolean canceled, Exception exception){
    	super(controllerContext);
    	this.actionDescriptor=actionDescriptor;
    	this.canceled=canceled;
    	this.exception=exception;
    	
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


	public Boolean getCanceled() {
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


	
}
