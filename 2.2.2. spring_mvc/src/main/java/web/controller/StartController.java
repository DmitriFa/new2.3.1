package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;

@Controller
public class StartController {
	private static User user;

	static {
		User user = new User();
		user.setName("Дмитрий");
		user.setLastName("Фадеев");
		user.setAge((byte) 54);

	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {

		return "index";
	}
	
}