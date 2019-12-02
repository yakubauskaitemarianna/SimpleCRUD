package com.miniservers.miniserver2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class miniServ2Conroller {
	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public String getHelloPage()
	{  
		return "new.html";
	}
}


