package com.udemy.controller;

import com.udemy.model.UserCredential;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);
    @GetMapping("/")
    public String redirectToLogin(){
        LOG.info("METHOD: redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name="error", required=false) String error,
            @RequestParam(name="logout", required = false)String logout){
        model.addAttribute("logout",
                logout);
        model.addAttribute("error", error);
        model.addAttribute("userCredentials",new UserCredential());
        LOG.info("METHOD: showLoginForm() -- PARAMS: error:"+error+", logout:"+logout);
        LOG.info("Returning to login view");
        return "login";
    }

    @PostMapping
    public String loginCheck(@ModelAttribute(name="userCredentials")UserCredential userCredential){
        LOG.info("METHOD: loginCheck() -- PARAMS: "+ userCredential);
        if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
            LOG.info("Returning to contacts view");
            return "contacts";
        }
        LOG.info("Redirect to login/error");
        return "redirect:/login?error";
    }
}
