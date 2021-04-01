package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
import ru.web.service.UserService;

@Controller
public class UserList {
    private final UserService userService;
    public UserList(UserService userService) {
        this.userService = userService;
    }
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
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "/update";
    }
    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
