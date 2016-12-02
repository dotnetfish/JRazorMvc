package com.superstudio.web.mvc.actionresult;

import java.io.IOException;

import com.superstudio.web.mvc.context.ControllerContext;
import com.superstudio.web.HttpResponseBase;

public class ContentResult extends ActionResult {

private	String content;
private String contentType;
private String contentEncoding;

	public ContentResult(String content, String contentType, String contentEncoding) {

		this.setContentEncoding(contentEncoding);
		this.setContent(content);
		this.contentType=contentType;
	}

	/**
	 * @param context
	 * @throws IOException
	 */
	@Override
	public void execute(ControllerContext context) throws IOException {

		HttpResponseBase response=context.getRequestContext().getResponse();
		response.setCharacterEncoding(this.contentEncoding);
		//response.setContentLength(this.content.length());
		response.setContentType(this.contentType);
		response.getWriter().write(content);
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}

}
