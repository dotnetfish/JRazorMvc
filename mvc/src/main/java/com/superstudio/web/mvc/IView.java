package com.superstudio.web.mvc;

import java.io.Writer;

import com.superstudio.jrazor.templateEngine.ViewContext;

public interface IView {
	void render(ViewContext viewContext, Writer writer) throws InstantiationException, IllegalAccessException;
}
