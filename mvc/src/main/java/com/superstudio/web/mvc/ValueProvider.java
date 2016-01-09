package com.superstudio.web.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;

import com.superstudio.web.mvc.context.RequestContext;

public class ValueProvider {
	Pattern rg = Pattern.compile("^(?<prefix>\\w+)\\[(?<key>\\w+)\\]$");
	private Map<String, String> dics;

	public ValueProvider(RequestContext context) {

		dics = new HashMap<String, String>();

		/*
		 * context.getRequest().getParameterMap().forEach((Object key,Object
		 * value)->{ dics.put(key.toString(),value.toString()); });
		 */
		Map<String, ?> map = context.getRequest().getParameterMap();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String[] values = (String[]) map.get(key);
			String result = "";
			for (String value : values) {
				result += "," + value; 
			}
			dics.put(key, result);
		}

		for (Cookie item : context.getRequest().getCookies()) {
			String key = item.getName();
			String value = item.getValue();
			dics.put(key, value);
			regexMathValue(key, value);
		}
	}

	private void regexMathValue(String key, String value) {

		Matcher match = rg.matcher(key);
		if (match.find()) {
			String pKey = match.group("prefix") + "." + match.group("key");
			if (dics.containsKey(pKey)) {
				dics.put(pKey, value);
			}

		}
	}

	public <T> T tryGetValue(String key) {
		if (dics.containsKey(key)) {
			return (T) dics.get(key);
		}
		return null;

	}
}