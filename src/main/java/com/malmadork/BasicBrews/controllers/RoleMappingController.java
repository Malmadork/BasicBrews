package com.malmadork.BasicBrews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleMappingController {

    @GetMapping( { "/login*" } )
    public String login (final Model model ) {
        return "login";
    }

}
