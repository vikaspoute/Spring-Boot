package com.first.boot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class FirstHandler {

    @RequestMapping("/first")
    public String handler() {
        return "Hello Vikas";
    }
}
