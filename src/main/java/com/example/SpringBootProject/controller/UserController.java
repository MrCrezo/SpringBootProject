package com.example.SpringBootProject.controller;


import com.example.SpringBootProject.model.User;
import com.example.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users/index";
    }

    @GetMapping("/show")
    public String getUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
