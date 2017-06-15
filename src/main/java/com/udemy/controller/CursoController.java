package com.udemy.controller;

import com.udemy.entity.Curso;
import com.udemy.service.CursoService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Guillermo Loyo on 18/05/2017.
 */
@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    @Qualifier("cursoService")
    CursoService cursoService;

    private static final String CURSOS_VIEW="cursos";
    private static final Log LOG = LogFactory.getLog(CursoController.class);

    @GetMapping("/listCursos")
    public ModelAndView listAllCursos(){
        LOG.info("Call: listAllCursos()");
        ModelAndView mav = new ModelAndView(CURSOS_VIEW);
        mav.addObject("curso",new Curso());
        mav.addObject("cursos", cursoService.getAllCursos());
        return mav;
    }

    @PostMapping("/agregarCurso")
    public String addCurso(@ModelAttribute("curso") Curso curso){
        LOG.info("Call: addCurso()-- Param: " + curso);
        cursoService.addCurso(curso);
        return "redirect:/curso/listCursos";
    }
}
