package org.pensatocode.simplicity.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String loadHome(Locale locale, Model model) {
        model.addAttribute("path", "home");
        model.addAttribute("content", "home");
        return "index";
    }
}
