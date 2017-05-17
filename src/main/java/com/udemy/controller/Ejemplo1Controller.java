package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Guillermo Loyo on 16/05/2017. s
 */
@Controller
@RequestMapping("/ejemplo1")
public class Ejemplo1Controller {
    public static final String EXAMPLE_VIEW="ejemplo";

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @GetMapping("/holamundoString")
    public String holaMundo(Model model){
        exampleComponent.hola();
        model.addAttribute("name", "Guillermo");
        return EXAMPLE_VIEW;
    }

    @GetMapping("/holamundoMAV")
    public ModelAndView holaMundoView(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name","Guillermo");
        return mav;
    }

    @GetMapping("/listaPersonas")
    public ModelAndView getListPeople(){
        ModelAndView mav = new ModelAndView("exampleListas");
        mav.addObject("people", exampleService.getListPeople());
        return mav;
    }
}
