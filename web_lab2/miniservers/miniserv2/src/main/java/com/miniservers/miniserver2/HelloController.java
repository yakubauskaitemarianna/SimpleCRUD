package com.miniservers.miniserver2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/temp")
    @ResponseBody
    public String welcome() {
        return "Welcome to 2nd server";
    }

}
