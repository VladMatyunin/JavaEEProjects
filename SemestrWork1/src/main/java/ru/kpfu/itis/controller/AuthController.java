package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Controller
public class AuthController {
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authorize(){
        return "authPage";
    }
}
