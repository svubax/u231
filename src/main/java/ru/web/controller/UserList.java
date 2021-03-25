package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.model.User;
import ru.web.service.UserService;

@Controller
public class UserList {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(@ModelAttribute("newUser") User newUser, Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }
    @PostMapping("/add")
    public String create(User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String add(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }
    @PostMapping("/update")
    public String edit(User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}
