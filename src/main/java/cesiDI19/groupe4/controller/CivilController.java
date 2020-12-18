package cesiDI19.groupe4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Civil;
import cesiDI19.groupe4.dao.CivilDao;
import cesiDI19.groupe4.services.CivilServices;

@Controller
public class CivilController {

	@Autowired
	CivilServices civilServices;

	@Autowired
	CivilDao civildao;

	@RequestMapping("/civil")
	public String home(@RequestParam(required = false, defaultValue = "World") String name, Model model) {
		Civil civil = new Civil();
		model.addAttribute("civil", civil);

		return "civil";
	}

	@RequestMapping(value ="/signup", method = RequestMethod.POST)
	public String save(@ModelAttribute("civil") Civil civil) {
		civildao.save(civil);
		return "redirect:/login"; //redirige vers login request mapping
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(required = false) String mail,
			@RequestParam(required = false) String mdp, Model model) {
		
	
	
		
		if (mail != null || mdp != null) {
			Civil civil = civildao.checklogin(mail, mdp);
			model.addAttribute("civil", civil);
			if (civil != null) {
				// Connexion à la session civil
				HttpSession session = request.getSession();
				session.setAttribute("Id", civil.getId());
				return "redirect:/incident";
			} else {
				// Erreur de connexion
				model.addAttribute("erreurMessage", "login ou mot de passe incorrect");
			}
		}
		return "login";

	}

}
