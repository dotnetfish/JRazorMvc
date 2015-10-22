# JRazorMvc
JRazorMvc is a mvc framework. It helps you to build your mvc wabapp with  lots of wonderful features.
#Features:
##1.Route config.
  you can just using the code or cfg to define your route rule.<br>
  the route would looks like this: 
  ```json
  { 
  name:"defaultRoute", 
  pattern:"/{area}/{controller}/{action}", 
  default:[area:"default",controller:"home",action:"index"], 
  packages:["org.superstudio.jrazormvc.demo","org.superstudio.jrazormvc.demo.controllers"] 
  } 
  ```
* name:the route name,it must be unique
* pattern: the url pattern
* default:the default value when the parameters define in pattern is missing
* packages: the route only search for the controllers and actions under the defined packages,when it is empty it look for all

or you can config your routes by coding,you need just init a Route object with parameters,then apply it to route table.
such as 
```java
    Route route = new Route() ;
		route.setArea("");
		route.setName("default");
		route.setPattern("/{controller}/{action}.html");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("controller", "home");
		map.put("action", "index");
		map.setPackages(new String[]{"com.superstudio.demo","com.superstudio.demo.controllers"});
		route.setDefault(map);
    Routes.mapRoute(route)
```
and it's threadsafe.

##2.JRazor Template engine
![github]https://github.com/dotnetfish/JRazor

##3.model binder
##4. supports POCO
##5.flexable. 
it allow you to apply every function with your own implements,such as controllerFactory,model binder,annomations

