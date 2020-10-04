package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserServiceImp;

import java.sql.SQLException;

@Controller
public class UserController {

    public UserController() {

    }

    private UserServiceImp serviceImp;

    public UserController(UserServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping(value = "/users")
    public String printUser(ModelMap model) throws SQLException {
        String tablename = "USERS";
        model.addAttribute("tablename", tablename);
        model.addAttribute("messages", serviceImp.getAllUsers());
        return "users";
    }
}
