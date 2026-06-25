package com.yash.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.yash.portfolio.entity.Contact;
import com.yash.portfolio.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/contact")
    public String save(Contact contact) {

        service.save(contact);

        return "redirect:/?success";
    }
}