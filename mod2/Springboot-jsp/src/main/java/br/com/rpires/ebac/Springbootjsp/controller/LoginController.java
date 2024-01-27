package br.com.rpires.ebac.Springbootjsp.controller;

import br.com.rpires.ebac.Springbootjsp.service.LoginService;

import javax.management.modelmbean.ModelMBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Steve.Vaz
 */
@ControllerAdvice
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMBean model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMBean model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }

}
