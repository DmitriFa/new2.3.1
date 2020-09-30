package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserServiceImp;

import java.sql.SQLException;

@Controller
public class UserController {

    public UserController() {

    }

    @Autowired
    private UserServiceImp serviceImp;

    @GetMapping(value = "/users")
    public String printCar( ModelMap model) throws SQLException {
          String  tablename = "USERS";
        model.addAttribute("tablename", tablename);
        model.addAttribute("messages",serviceImp.getAllUsers());
        return "users";
    }
}
