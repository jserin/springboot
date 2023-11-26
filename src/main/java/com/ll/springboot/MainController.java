package com.ll.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String index() {
        return "main";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/main";
    }
}
