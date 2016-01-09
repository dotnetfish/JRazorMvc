package com.superstudio.web.mvc.actionresult;

import java.util.List;

import com.superstudio.commons.exception.ArgumentNullException;
import com.superstudio.web.mvc.IView;

public class ViewEngineResult {

	public ViewEngineResult(List<String> searchedLocations) throws ArgumentNullException {
		if (searchedLocations == null) {
			throw new ArgumentNullException("searchedLocations");
		}

		this.searchedLocations = searchedLocations;//Arrays.asList(searchedLocations);
	}

	public ViewEngineResult(IView view, IViewEngine viewEngine) throws ArgumentNullException {
		if (view == null) {
			throw new ArgumentNullException("view");
		}
		if (viewEngine == null) {
			throw new ArgumentNullException("viewEngine");
		}

		this.view = view;
		this.viewEngine = viewEngine;
	}

	public List<String> getSearchedLocations() {
		return searchedLocations;
	}

	public IView getView() {
		return view;
	}

	public IViewEngine getViewEngine() {
		return viewEngine;
	}

	private List<String> searchedLocations;

	private IView view;
	private IViewEngine viewEngine;

}
