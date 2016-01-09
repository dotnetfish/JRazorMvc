package com.superstudio.web.servlet;

import com.superstudio.web.mvc.ControllerBase;
import com.superstudio.commons.reflactor.annotations.ClassFilter;

public class ControllerClassFilter extends ClassFilter {

	@Override
	public Boolean test(Class<?> calzz) {
		// TODO Auto-generated method stub
		return calzz.isAssignableFrom(ControllerBase.class);
	}

}
