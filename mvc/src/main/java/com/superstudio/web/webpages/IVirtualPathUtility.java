package com.superstudio.web.webpages;



public interface IVirtualPathUtility
{
	String Combine(String basePath, String relativePath);

	String ToAbsolute(String virtualPath);
}