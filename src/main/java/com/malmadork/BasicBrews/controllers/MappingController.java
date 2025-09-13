package com.malmadork.BasicBrews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingController {

    @GetMapping ( { "/index*", "/"} )
    public String index (final Model model) {
        return "index";
    }

    @GetMapping ( { "/register*"} )
    public String register (final Model model ) {
        return "register";
    }

    @GetMapping ( { "/loginSuccess"} )
    public String loginSuccess (final Model model ) {
        model.addAttribute("success", "true");
        return "login";
    }

}
