package cesiDI19.groupe4.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "account")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "connexion/index";
	}

	@RequestMapping(value = "connexion", method = RequestMethod.POST)
	public String connexion(
		@RequestParam("username") String username,
		@RequestParam("mdp") String mdp,
		HttpSession session,
		ModelMap modelMap) {
		if(username.equalsIgnoreCase("test") && mdp.equalsIgnoreCase("test")) {
			session.setAttribute("username", username);
			return "connexion/home";
		} else {
			modelMap.put("error", "Invalid Account");
			return "connexion/index";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../connexion";
	}

}