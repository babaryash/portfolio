package com.yash.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yash.portfolio.entity.Contact;
import com.yash.portfolio.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public void save(Contact contact) {

        // Save to MySQL
        repository.save(contact);

        // Send Email
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("babaryash2003@gmail.com");
        mail.setSubject("New Portfolio Contact Message");

        mail.setText(
                "Name: " + contact.getName()
                + "\nEmail: " + contact.getEmail()
                + "\nSubject: " + contact.getSubject()
                + "\nMessage: " + contact.getMessage()
        );

        mailSender.send(mail);
        
     // Auto Reply Mail

        SimpleMailMessage reply = new SimpleMailMessage();

        reply.setTo(contact.getEmail());

        reply.setSubject("Thank You For Contacting Me");

        reply.setText(
                "Hello " + contact.getName() + ",\n\n"
              + "Thank you for contacting me through my portfolio website.\n"
              + "I have received your message and will get back to you soon.\n\n"
              + "Best Regards,\n"
              + "Yash Babar\n"
              + "Java Full Stack Developer"
        );

        mailSender.send(reply);
    }
}