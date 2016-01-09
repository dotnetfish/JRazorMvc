package com.superstudio.web.mvc.actionresult;

import java.io.IOException;

import com.superstudio.commons.exception.ArgumentNullException;
import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.commons.exception.ArgumentException;
import com.superstudio.commons.exception.InvalidOperationException;

public abstract class ActionResult {

	public abstract  void execute(ControllerContext context) throws IOException, ArgumentNullException, InvalidOperationException, ArgumentException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
