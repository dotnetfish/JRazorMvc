package com.superstudio.web.mvc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;



public interface IBuildManager
{
	boolean fileExists(String virtualPath);
	java.lang.Class getCompiledType(String virtualPath);
	Collection getReferencedAssemblies();
	InputStream readCachedFile(String fileName);
	OutputStream createCachedFile(String fileName);
}