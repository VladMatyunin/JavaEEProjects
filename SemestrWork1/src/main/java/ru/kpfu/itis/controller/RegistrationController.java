package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.RegistrForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.validation.Valid;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Controller
public class RegistrationController {
   @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String loadRegistration(ModelMap modelMap){
        modelMap.addAttribute("regform",new RegistrForm());
        return "regpage";
    }
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String authenticate(@Valid @ModelAttribute("regform") RegistrForm regform,
                               BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "regpage";
        }
        else{
            if (regform.getConfirmPassword().equals(regform.getPassword()) == false){
                modelMap.addAttribute("passwordError","Пароли не совпадают");
                return "regpage";
            }
            if (userRepository.findByEmail(regform.getEmail())!=null){
                modelMap.addAttribute("emailExists","Пользователь с такой почтой уже зарегистрирован");
                return "regPage";
            }
            userRepository.save(new User(regform.getName(),regform.getSurname(),regform.getEmail(),regform.getPassword()));
            return "mainpage";
        }
    }
}
