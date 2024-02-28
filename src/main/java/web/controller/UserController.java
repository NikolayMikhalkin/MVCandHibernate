package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
public class UserController {

    private final UserService userServiceImp;

    @Autowired
    public UserController (UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping(value = "/")
    public String printCars(ModelMap model) {
        List<User> users = userServiceImp.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}