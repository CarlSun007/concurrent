package src.main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "jqueryajax1";
	}
	@RequestMapping("login1.do")
	    public String login(String username,String password,ModelMap model){
	        if ("admol".equals(username)) {
	            System.out.println(username +" 登录成功");
	            
	    		model.addAttribute("greeting", "Hello World Again1"+username);

	            return "welcome";//逻辑视图名       跳转页面默认为转发
	        }
	        return "loginError";
	    }    

}