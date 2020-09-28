package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserServiceImp;

import java.sql.SQLException;

@Controller
public class UserController {
    private UserServiceImp userService;

    public UserController() {

    }

   // @Autowired
    public UserController(UserServiceImp userService) {

        this.userService = userService;
    }
    
   UserServiceImp serviceImp = new UserServiceImp();
    @GetMapping(value = "/users")
    public String printCar( ModelMap model) throws SQLException {
          String  tablename = "USERS";
        model.addAttribute("tablename", tablename);
        model.addAttribute("messages",serviceImp.getAllUsers());
        return "users";
    }
}
