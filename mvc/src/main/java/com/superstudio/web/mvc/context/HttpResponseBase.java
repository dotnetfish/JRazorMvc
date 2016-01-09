package com.superstudio.web.mvc.context;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

public class HttpResponseBase {

	private HttpServletResponse response;
	public HttpResponseBase(HttpServletResponse response) {
		this.response=response;
	}
	
	public void write(String s) throws IOException{
		response.getWriter().write(s);
	}
	
	public Writer getWriter() throws IOException{
		return this.response.getWriter();
		
	}

	public void setCharacterEncoding(String contentEncoding) {
		response.setCharacterEncoding(contentEncoding);
		
	}

	public void setContentType(String contentType) {
		// TODO Auto-generated method stub
		response.setContentType(contentType);
	}

}
