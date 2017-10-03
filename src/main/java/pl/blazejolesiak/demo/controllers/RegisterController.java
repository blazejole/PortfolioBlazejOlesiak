package pl.blazejolesiak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.blazejolesiak.demo.models.UserModel;
import pl.blazejolesiak.demo.models.repositories.IUserRepository;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    IUserRepository iUserRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String logIn(Model model){
        model.addAttribute("userModel", new UserModel());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userModel")@Valid UserModel userModel,BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()) {

            if (iUserRepository.findAll().stream().anyMatch(s -> s.getUsername().equals(userModel.getUsername()))) {
                model.addAttribute("notEmpty", "podany nick jest zajety, sproboj jeszcze raz");
                return "register";
            }
            if(!userModel.getPassword().equals(userModel.getConfirmPass())){
                model.addAttribute("notEmpty", "podane hasła nie sa takie same");
                return "register";
            }
            iUserRepository.save(userModel);
            model.addAttribute("message", "Dodano nowego użytkownika do bazy pod nickiem: ! -> " + userModel.getUsername() + " <- ");
            return "responseLog";
        }
            return "register";
    }


}
