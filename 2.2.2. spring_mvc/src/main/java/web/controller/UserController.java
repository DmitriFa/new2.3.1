package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    public UserController() {
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) throws Exception {
        model.addAttribute("messages", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") int id, ModelMap model) throws Exception {
        List<User> users = new ArrayList<>();
        users.add(userService.getUserById(id));
        model.addAttribute("messages", users);
        return "users";
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage(@ModelAttribute("messages") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }
    @GetMapping(value = "/edit")
    public ModelAndView editPage(@ModelAttribute("messages") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getUserById(id);
        userService.removeUser(user);
        return modelAndView;
    }
    @PostMapping(value = "/users")
    public String create(@RequestParam("lastname")String lastname,@RequestParam("name")String name,@RequestParam("age")Byte age,ModelMap model) throws Exception {
        User user = new User();
        user.setLastName(lastname);
        user.setName(name);
        user.setAge(age);
        userService.addUser(user);
        model.addAttribute("messages",user);
        return "users";
    }

}



