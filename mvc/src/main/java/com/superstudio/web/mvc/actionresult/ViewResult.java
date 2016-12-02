package com.superstudio.web.mvc.actionresult;

import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.commons.CultureInfo;
import com.superstudio.commons.MvcResources;
import com.superstudio.commons.csharpbridge.StringHelper;
import com.superstudio.commons.exception.ArgumentException;
import com.superstudio.commons.exception.ArgumentNullException;
import com.superstudio.commons.exception.InvalidOperationException;

public class ViewResult extends ViewResultBase {

	private String masterName;

	public String getMasterName() {
		return masterName == null ? "" : masterName;
	}

	public void setMasterName(String value) {
		this.masterName = value;
	}

	@Override
	protected ViewEngineResult findView(ControllerContext context)
			throws InvalidOperationException, ArgumentNullException, ArgumentException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		ViewEngineResult result = getViewEngine().findView(context, getViewName(), getMasterName());
		if (result.getView() != null) {
			return result;
		}

		// we need to generate an exception containing all the locations we
		// searched
		StringBuilder locationsText = new StringBuilder();
		for (String location : result.getSearchedLocations()) {
			locationsText.append("\t\n");
			locationsText.append(location);
		}
		throw new InvalidOperationException(StringHelper.format(CultureInfo.CurrentCulture,
				MvcResources.Common_ViewNotFound, new Object[] { getViewName(), locationsText }));
	}

}
