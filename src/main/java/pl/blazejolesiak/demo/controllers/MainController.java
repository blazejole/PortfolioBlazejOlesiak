package pl.blazejolesiak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.blazejolesiak.demo.models.AboutModel;
import pl.blazejolesiak.demo.models.ProjectModel;
import pl.blazejolesiak.demo.models.TitleModel;
import pl.blazejolesiak.demo.models.forms.EmailForm;

import pl.blazejolesiak.demo.models.repositories.IAboutMeRepository;
import pl.blazejolesiak.demo.models.repositories.IProjectRepository;
import pl.blazejolesiak.demo.models.repositories.ITitleRepository;
import pl.blazejolesiak.demo.models.services.EmailService;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ITitleRepository iTitleRepository;

    @Autowired
    IProjectRepository iProjectRepository;

    @Autowired
    IAboutMeRepository iAboutMeRepository;


    @GetMapping("/")
    public String showAll(){
        return "index";
    }

    @ModelAttribute("titleMessage")
    TitleModel model(){
        return iTitleRepository.findOne(1);
    }

    @ModelAttribute("myprojects")
    List<ProjectModel> projectsToPortfolio(){
        return (List<ProjectModel>) iProjectRepository.findAll();
    }


    @ModelAttribute("aboutMe")
    AboutModel aboutMe(){return iAboutMeRepository.findOne(1);}


    @Autowired
    EmailService emailService;

    @Autowired
    TemplateEngine templateEngine;

    @RequestMapping ("/")
    public String index(Model model){
        model.addAttribute("emailForm", new EmailForm());
        model.addAttribute("succes", false);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String Form(@RequestBody EmailForm emailForm,Model model){
        Context context = new Context();
        context.setVariable("name", "Name "+emailForm.getName());
        context.setVariable("phonenumber", "Phone "+emailForm.getPhonenumber());
        context.setVariable("message", "Wiadomość: " +emailForm.getMessage());

        String bodyHTML = templateEngine.process("simpleEmail", context);

        emailService.sendMessage(bodyHTML,emailForm.getEmail(),emailForm.getEmail());

        model.addAttribute("success", true);
        model.addAttribute("emailForm", new EmailForm());
        System.out.println(" > WYSŁANO < Adres nadawcy: " + emailForm.getEmail());
        return "index";

    }







}
