package com.superstudio.web.mvc.descriptor;

import com.superstudio.web.mvc.context.ControllerContext;

public abstract class ActionSelector {
	public abstract Boolean execute(ControllerContext controllerContext);
}
