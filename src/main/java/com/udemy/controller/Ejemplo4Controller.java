package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Controller
@RequestMapping("/ejemplo4")
public class Ejemplo4Controller {
    public static final String VIEW_404 = "404";

    @GetMapping("/page404")
    public String page404(){
        return VIEW_404;
    }

    @GetMapping("/page500")
    public String page500(){
        return "500";
    }
}
