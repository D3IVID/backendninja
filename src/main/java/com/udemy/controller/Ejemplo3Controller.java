package com.udemy.controller;

import com.udemy.repository.Persona;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Controller
@RequestMapping("/ejemplo3")
public class Ejemplo3Controller {

    public static final Log LOGGER = LogFactory.getLog(Ejemplo3Controller.class);
    public static final String FORM_VIEW = "form";

    //Redirect 1
    /*@GetMapping("/")
    public String redirect(){
        return "redirect:/ejemplo3/showForm";
    }*/

    //Redirect 2
    @GetMapping("/")
    public RedirectView redirectView(){
        return new RedirectView("/ejemplo3/showForm");
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("persona", new Persona());
        return FORM_VIEW;
    }

    @PostMapping("/agregarPersona")
    public ModelAndView agregarPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors())
            mav.setViewName(FORM_VIEW);
        else
            mav.setViewName("result");
            mav.addObject("persona", persona);

        return mav;
    }

}
