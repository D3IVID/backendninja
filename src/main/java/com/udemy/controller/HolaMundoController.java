package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Guillermo Loyo on 16/05/2017. s
 */
@Controller
@RequestMapping("/di")
public class HolaMundoController {
    public static final String EXAMPLE_VIEW="HolaMundo";

    @GetMapping("/holamundoString")
    public String holaMundo(Model model){
        model.addAttribute("name", "Guillermo");
        return EXAMPLE_VIEW;
    }

    @GetMapping("/holamundoMAV")
    public ModelAndView holaMundoView(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name","Guillermo");
        return mav;
    }
}
