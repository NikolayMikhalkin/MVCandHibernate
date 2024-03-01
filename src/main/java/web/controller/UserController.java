package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private final UserService userServiceImp;

    @Autowired
    public UserController (UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    /*@ModelAttribute("user")
    public User getOurUser() {
        return new User();
    }*/

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

    @GetMapping("/add-user")
    public String showAddForm(@ModelAttribute("user") User user) {
        return "createUser";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImp.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit-user")
    public  String showGetUserForm(@ModelAttribute("user") User user) {
        return "updateUser";
    }

    @PostMapping("/edit-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImp.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/remove-user")
    public String deleteUser(@RequestParam("id") Long id) {
        userServiceImp.removeUser(id);
        return "redirect:/users";
    }
}
