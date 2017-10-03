package pl.blazejolesiak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blazejolesiak.demo.models.portfolioModel.AboutModel;
import pl.blazejolesiak.demo.models.portfolioModel.ProjectModel;
import pl.blazejolesiak.demo.models.portfolioModel.TitleModel;
import pl.blazejolesiak.demo.models.EmailModel;

import pl.blazejolesiak.demo.models.repositories.portfolioRepository.IAboutMeRepository;
import pl.blazejolesiak.demo.models.repositories.portfolioRepository.IProjectRepository;
import pl.blazejolesiak.demo.models.repositories.portfolioRepository.ITitleRepository;
import pl.blazejolesiak.demo.models.services.EmailService;
import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    ITitleRepository iTitleRepository;

    @Autowired
    IProjectRepository iProjectRepository;

    @Autowired
    IAboutMeRepository iAboutMeRepository;


    @Autowired
    EmailService emailService;

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

    @RequestMapping ("/portfolio")
    public String index(Model model){
        model.addAttribute("emailForm", new EmailModel());
        return "index";
    }

    @PostMapping("/portfolio")
    public String sendEm(@ModelAttribute("emailForm") EmailModel emailModel, Model model){
        emailService.sendMessage(emailModel);
        model.addAttribute("message" , "Wiadomosc wyslana pod adres: blazej.olesiak@gmail.com");
        return "index";
    }

    //    @Autowired
//    TemplateEngine templateEngine;
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String form(@RequestBody EmailModel emailForm,Model model){
//        Context context = new Context();
//        context.setVariable("name", "Name "+emailForm.getName());
//        context.setVariable("phonenumber", "Phone "+emailForm.getPhonenumber());
//        context.setVariable("message", "Wiadomość: " +emailForm.getMessage());
//
//        String bodyHTML = templateEngine.process("simpleEmail", context);
//
//        emailService.sendMessage(bodyHTML,emailForm.getEmail());
//        model.addAttribute("success", true);
//        model.addAttribute("emailForm", new EmailModel());
//        System.out.println(" > WYSŁANO < Adres nadawcy: " + emailForm.getEmail());
//        return "index";
//
//    }
}
