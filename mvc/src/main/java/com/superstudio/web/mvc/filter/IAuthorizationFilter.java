package com.superstudio.web.mvc.filter;

import com.superstudio.web.mvc.context.AuthorizationContext;

public interface IAuthorizationFilter {
	void onAuthorization(AuthorizationContext filterContext);
}
