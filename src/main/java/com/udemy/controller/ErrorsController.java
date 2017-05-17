package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@ControllerAdvice
public class ErrorsController {
    public static final String ISE_VIEW = "error/500";

    @ExceptionHandler(Exception.class)
    public String showInternalServerError(){
        return ISE_VIEW;
    }
}
