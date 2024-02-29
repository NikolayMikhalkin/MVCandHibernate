package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        List<User> users = userServiceImp.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/get_user")
    public  String getUser(@ModelAttribute("user") User user) {
        return "updateUser";
    }

    @PostMapping("/add_user")
    public String addUser() {
        return "createUser";
    }
}