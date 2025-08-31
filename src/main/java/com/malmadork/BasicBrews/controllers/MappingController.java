package com.malmadork.BasicBrews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    @GetMapping ( { "/index", "/"} )
    public String index (final Model model ) {
        return "index";
    }
}
