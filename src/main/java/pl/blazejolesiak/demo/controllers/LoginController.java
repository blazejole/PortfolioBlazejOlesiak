package pl.blazejolesiak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.blazejolesiak.demo.models.UserModel;
import pl.blazejolesiak.demo.models.repositories.IUserRepository;

@Controller
public class LoginController {

    @Autowired
    IUserRepository iUserRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(Model model){
        model.addAttribute("logModel", new UserModel());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String findUsername(@ModelAttribute("logModel") UserModel userModel, Model model){
        if(!iUserRepository.findByUsername(userModel.getUsername()).isPresent()){
            model.addAttribute("messageToUser", "Taki uzytkownik nie istnieje! ");
            return "login";
        }
        if(!iUserRepository.findByEmail(userModel.getEmail()).isPresent()){
            model.addAttribute("messageToUser", "Taki użtykownik nie istnieje");
            return "login";
        }

        return "responseLog";
    }



}
