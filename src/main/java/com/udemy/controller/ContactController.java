package com.udemy.controller;

import com.udemy.contans.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Guillermo Loyo on 4/8/2017.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    ContactService contactService;

    @GetMapping("/cancel")
    public String cancel(){
        return ViewConstant.CONTACTS;
    }

    @GetMapping("/contactform")
    public String redirectContactForm(Model model){
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,
                             Model model){
        model.addAttribute("result",contactService.addContact(contactModel)!=null?1:0);
        LOG.info("METHOD: addcontact() -- PARAMS: "+ contactModel);
        return ViewConstant.CONTACTS;
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts(){
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        mav.addObject("contacts",contactService.listAllContacts());
        return mav;
    }
}
