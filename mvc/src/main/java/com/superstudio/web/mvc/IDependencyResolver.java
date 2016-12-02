package com.superstudio.web.mvc;



public interface IDependencyResolver
{
	Object getService(java.lang.Class<?> serviceType);
	Iterable<Object> getServices(java.lang.Class<?> serviceType);
}