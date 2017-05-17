package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */

@Controller
@RequestMapping("/ejemplo2")
public class Ejemplo2Controller {

    public static final String EJEMPLO2_VIEW = "/ejemplo2";

    //FORMATO http://localhost:8080/ejemplo2/request1?nm=JON
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm") String name){
        ModelAndView mav = new ModelAndView(EJEMPLO2_VIEW);
        mav.addObject("nombre_mav", name);
        return mav;
    }

    @GetMapping("/request1False")
    public ModelAndView request1False(@RequestParam(name="nm",required=false) String name){
        ModelAndView mav = new ModelAndView(EJEMPLO2_VIEW);
        mav.addObject("nombre_mav", name);
        return mav;
    }

    @GetMapping("/request1DefaultValue")
    public ModelAndView request1DefaultValue(@RequestParam(name="nm",required=false, defaultValue = "Anonimo") String name){
        ModelAndView mav = new ModelAndView(EJEMPLO2_VIEW);
        mav.addObject("nombre_mav", name);
        return mav;
    }

    //FORMATO http://localhost:8080/ejemplo2/request2/JON
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable(value = "nm") String name){
        ModelAndView mav = new ModelAndView(EJEMPLO2_VIEW);
        mav.addObject("nombre_mav",name);
        return mav;
    }
}
