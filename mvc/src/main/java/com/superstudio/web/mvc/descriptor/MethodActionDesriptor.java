package com.superstudio.web.mvc.descriptor;

import java.lang.reflect.Method;
import java.util.Map;

import com.superstudio.web.mvc.Controller;
import com.superstudio.web.mvc.context.ActionExecutedContext;
import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.web.mvc.context.ExceptionContext;


public class MethodActionDesriptor extends ActionDescriptor {

	private Method method;
	
	public MethodActionDesriptor(ControllerDescriptor controller,Method method){
		this.setControllerDescriptor(controller);
		this.method=method;
		this.setActionName(method.getName());
	}
	@Override
	public Object execute(ControllerContext controllerContext, Map<String, Object> parameters) throws InstantiationException, IllegalAccessException{
		Controller controller=(Controller)controllerContext.getController();
try{
ActionExecutedContext executingContext=new ActionExecutedContext();
	
	controller.onActionExecuted(executingContext);
	if(executingContext.getCanceled()){
		return executingContext.getResult();
	}
	Object result=null;
	if(this.method.getParameterCount()==0){
		result= this.method.invoke(controller);
	}else{
		 result= this.method.invoke(controller,parameters);
	}
	
	
	ActionExecutedContext executedContext=new ActionExecutedContext();
	executedContext.setRequestContext(controllerContext.getRequestContext());
	controller.onActionExecuted(executedContext);
	return result;
}catch(Exception ex){
	ExceptionContext context=new ExceptionContext();
	context.setController(controllerContext.getController());
	context.setException(ex);
	context.setExceptionHandled(false);
	context.setHttpContext(controllerContext.getHttpContext());
	context.setRequestContext(controllerContext.getRequestContext());
	controller.onException(context);
	return null;
	//if(controller.r)
}

	}

	@Override
	public ParameterDescriptor[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
