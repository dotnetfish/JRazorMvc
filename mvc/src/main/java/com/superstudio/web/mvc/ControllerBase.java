package com.superstudio.web.mvc;

import java.util.HashMap;
import java.util.Map;

import com.superstudio.jrazor.templateEngine.ViewDataDictionary;
import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.web.mvc.context.RequestContext;

public abstract class ControllerBase {

	public void initialize(RequestContext requestContext) {
		tempData=new HashMap<String,Object>();
		viewData=new ViewDataDictionary(tempData);
		
		
		//setViewData(new )
	}
	
	protected ControllerBase(){
		
	}

	private ControllerContext controllerContext;
    public ControllerContext getControllerContext(){ 
    	return this.controllerContext;
    }
    private Map<String,Object> tempData;
   // public Boolean ValidateRequest { get; set; }
    public IValueProvider valueProvider;
   
   // public dynamic ViewBag { get; }
    private ViewDataDictionary viewData;

    protected  void execute(RequestContext requestContext){
    	
    };
    protected abstract void executeCore();

	public Map<String,Object> getTempData() {
		return tempData;
	}

	public void setTempData(Map<String,Object> tempData) {
		this.tempData = tempData;
	}

	public ViewDataDictionary getViewData() {
		return viewData;
	}

	public void setViewData(ViewDataDictionary viewData) {
		this.viewData = viewData;
	}
  

}
