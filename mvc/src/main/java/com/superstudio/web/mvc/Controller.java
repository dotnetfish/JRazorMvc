package com.superstudio.web.mvc;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

import com.superstudio.jrazor.templateEngine.ViewEngineCollection;
import com.superstudio.web.HttpRequestBase;
import com.superstudio.web.mvc.filter.IActionFilter;
import com.superstudio.web.mvc.filter.IExceptionFilter;
import com.superstudio.web.mvc.filter.IResultFilter;
import com.superstudio.web.mvc.viewEngine.ViewEngines;
import com.superstudio.web.HttpContextBase;
import com.superstudio.web.HttpResponseBase;
import com.superstudio.web.mvc.actionresult.ContentResult;
import com.superstudio.web.mvc.actionresult.FileContentResult;
import com.superstudio.web.mvc.actionresult.FilePathResult;
import com.superstudio.web.mvc.actionresult.FileStreamResult;
import com.superstudio.web.mvc.actionresult.httpNotFoundResult;
import com.superstudio.web.mvc.actionresult.JavaScriptResult;
import com.superstudio.web.mvc.actionresult.JsonRequestBehavior;
import com.superstudio.web.mvc.actionresult.JsonResult;
import com.superstudio.web.mvc.actionresult.PartialViewResult;
import com.superstudio.web.mvc.actionresult.RedirectResult;
import com.superstudio.web.mvc.actionresult.RedirectToRouteResult;
import com.superstudio.web.mvc.actionresult.ViewResult;
import com.superstudio.web.mvc.context.ActionExecutedContext;
import com.superstudio.web.mvc.context.ActionExecutingContext;
import com.superstudio.web.mvc.context.AuthorizationContext;
import com.superstudio.web.mvc.context.ExceptionContext;
import com.superstudio.web.mvc.context.HttpSessionStateBase;
import com.superstudio.web.mvc.context.RequestContext;
import com.superstudio.web.mvc.context.ResultExecutedContext;
import com.superstudio.web.mvc.context.ResultExecutingContext;
import com.superstudio.web.mvc.filter.IAuthorizationFilter;

public abstract class Controller extends ControllerBase
		implements IActionFilter, IAuthorizationFilter, IExceptionFilter, IResultFilter {

	@Override
	public void onActionExecuted(ActionExecutedContext filterContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActionExecuting(ActionExecutingContext filterContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAuthorization(AuthorizationContext filterContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(ExceptionContext filterContext) {
		try {
			Writer writer = filterContext.getRequestContext().getResponse().getWriter();
			Exception ex = filterContext.getException();
			writer.write(ex.getMessage() == null ? ex.toString() : ex.getMessage());
			writer.write("\r\n-----------stack trace---------------------\r\n");
			for (StackTraceElement trace : ex.getStackTrace()) {
				writer.write(String.format("\r\nat %s(%s:%d)", trace.getClassName(), trace.getFileName(),
						trace.getLineNumber()));
			}
			writer.write("\r\n-------------------end stack trace----------------------------\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onResultExecuted(ResultExecutedContext filterContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResultExecuting(ResultExecutingContext filterContext) {
		// TODO Auto-generated method stub

	}

	protected Controller() {
		// return null;
	}

	// public IActionInvoker ActionInvoker {
	// return null;}
	// protected ModelBinderDictionary Binders { get{
	// return null;}set{return null;}}

	private HttpContextBase httpContext;

	public HttpContextBase getHttpContext() {
		return httpContext;
	}
	// public ModelStateDictionary ModelState { get{
	// return null;}}

	private HttpRequestBase request;

	public HttpRequestBase getRequest() {
		return request;
	}

	private HttpResponseBase response;

	public HttpResponseBase getResponse() {
		return response;
	}

	private RouteData routeData;

	public RouteData getRouteData() {
		return routeData;
	}
	// public HttpServerUtilityBase Server { get{
	// return null;}}

	private HttpSessionStateBase session;

	public HttpSessionStateBase getSession() {
		return session;
	}

	// public ITempDataProvider TempDataProvider { get{
	// return null;

	// }set{return null;}}
	// public UrlHelper Url { get{
	// return null;}set{return null;}}
	// public IPrincipal User { get{
	// return null;}}

	protected ContentResult content(String content) {

		return content(content, "text/html", "utf-8");
	}

	protected ContentResult content(String content, String contentType) {

		return content(content, contentType, "utf-8");
	}

	protected ContentResult content(String content, String contentType, String contentEncoding) {

		return new ContentResult(content, contentType, contentEncoding);
	}

	// protected IActionInvoker CreateActionInvoker(){
	// return null;

	// }
	// protected ITempDataProvider CreateTempDataProvider(){
	// return null;}

	// public void Dispose(){
	// return null;
	// }
	// protected void Dispose(Boolean disposing){
	// return null;

	// }
	// protected override void ExecuteCore(){
	// return null;

	// }

	protected FileContentResult file(byte[] fileContents, String contentType) {
		// TODO:
		return null;
	}

	protected FileStreamResult file(Stream fileStream, String contentType) {
		// TODO:
		return null;
	}

	protected FilePathResult file(String fileName, String contentType) {
		// TODO:
		return null;
	}

	protected FileContentResult file(byte[] fileContents, String contentType, String fileDownloadName) {
		// TODO:
		return null;
	}

	protected FileStreamResult file(Stream fileStream, String contentType, String fileDownloadName) {
		// TODO:
		return null;
	}

	protected FilePathResult file(String fileName, String contentType, String fileDownloadName) {
		// TODO:
		return null;
	}

	protected void handleUnknownAction(String actionName) {
		// TODO:
		// return null;
	}

	protected httpNotFoundResult httpNotFound() {
		// TODO:
		return null;
	}

	protected httpNotFoundResult httpNotFound(String statusDescription) {
		// TODO:
		return null;
	}

	@Override
	public void initialize(RequestContext requestContext) {
		super.initialize(requestContext);

	}

	protected JavaScriptResult javaScript(String script) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data, JsonRequestBehavior behavior) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data, String contentType) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data, String contentType, String contentEncoding) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data, String contentType, JsonRequestBehavior behavior) {
		// TODO:
		return null;
	}

	protected JsonResult json(Object data, String contentType, String contentEncoding, JsonRequestBehavior behavior) {
		// TODO:
		return null;
	}

	protected PartialViewResult partialView() {
		return null;
	}

	protected PartialViewResult partialView(Object model) {
		return null;
	}

	protected PartialViewResult partialView(String viewName) {
		return null;
	}

	protected PartialViewResult partialView(String viewName, Object model) {
		return null;
	}

	protected RedirectResult redirect(String url) {
		return null;

	}

	protected RedirectResult redirectPermanent(String url) {
		return null;

	}

	protected RedirectToRouteResult redirectToAction(String actionName) {
		return null;
	}

	protected RedirectToRouteResult redirectToAction(String actionName, Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToAction(String actionName, RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToAction(String actionName, String controllerName) {
		return null;
	}

	protected RedirectToRouteResult redirectToAction(String actionName, String controllerName, Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToAction(String actionName, String controllerName,
													 RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName, Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName, RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName, String controllerName) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName, String controllerName,
															  Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToActionPermanent(String actionName, String controllerName,
															  RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoute(Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoute(RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoute(String routeName) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoute(String routeName, Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoute(String routeName, RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoutePermanent(Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoutePermanent(RouteValueDictionary routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoutePermanent(String routeName) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoutePermanent(String routeName, Object routeValues) {
		return null;
	}

	protected RedirectToRouteResult redirectToRoutePermanent(String routeName, RouteValueDictionary routeValues) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, IValueProvider valueProvider) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String[] includeProperties) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix,
															 IValueProvider valueProvider) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix, String[] includeProperties) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String[] includeProperties,
															 IValueProvider valueProvider) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix, String[] includeProperties,
															 IValueProvider valueProvider) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix, String[] includeProperties,
															 String[] excludeProperties) {
		return null;
	}

	protected <TModel extends Object> Boolean tryUpdateModel(TModel model, String prefix, String[] includeProperties,
															 String[] excludeProperties, IValueProvider valueProvider) {
		return null;
	}

	protected <TModel> Boolean tryValidateModel(Object model) {
		return null;
	}

	protected <TModel> Boolean tryValidateModel(Object model, String prefix) {
		return null;
	}

	protected <TModel extends Object> void updateModel(TModel model) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, IValueProvider valueProvider) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String[] includeProperties) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix, IValueProvider valueProvider) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix, String[] includeProperties) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String[] includeProperties,
													   IValueProvider valueProvider) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix, String[] includeProperties,
													   IValueProvider valueProvider) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix, String[] includeProperties,
													   String[] excludeProperties) {
		// return null;
	}

	protected <TModel extends Object> void updateModel(TModel model, String prefix, String[] includeProperties,
													   String[] excludeProperties, IValueProvider valueProvider) {
		// return null;
	}

	protected void validateModel(Object model) {
		// return null;
	}

	protected void validateModel(Object model, String prefix) {
		// return null;
	}

	protected ViewResult view() {
		// TODO:
		return null;
	}

	protected ViewResult view(IView view) {
		// TODO:
		return null;
	}

	protected ViewResult view(Object model) {
		// TODO:
		return view("", "", model);
	}

	protected ViewResult view(String viewName) {
		// TODO:
		return view(viewName, "", null);
	}

	protected ViewResult view(IView view, Object model) {
		// TODO:
		return null;
	}

	protected ViewResult view(String viewName, Object model) {
		// TODO:
		return view(viewName, "", null);
	}

	protected ViewResult view(String viewName, String masterName) {
		// TODO:
		return view(viewName, masterName, null);
	}

	private ViewEngineCollection viewEngineCollection;

	protected ViewResult view(String viewName, String masterName, Object model) {
		if (model != null) {
			getViewData().setModel(model);
		}

		ViewResult result = new ViewResult();
		result.setMasterName(masterName);
		result.setViewData(getViewData());

		result.setTempData(getTempData());
		result.setViewEngine(getViewEngineCollection());
		return result;

	}

	public ViewEngineCollection getViewEngineCollection() {
		return viewEngineCollection == null ? ViewEngines.Engines : viewEngineCollection;
	}

	public void setViewEngineCollection(ViewEngineCollection _viewEngineCollection) {
		this.viewEngineCollection = _viewEngineCollection;
	}

	// private RouteCollection routeCollection;
	/*
	 * { get { if (_routeCollection == null) { _routeCollection =
	 * RouteTable.Routes; } return _routeCollection; } set { _routeCollection =
	 * value; } }
	 */

}
