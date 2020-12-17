package cesiDI19.groupe4.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		Civil civil = civilServices.getCivil();
		model.addAttribute("civil", civil);

		return "civil";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(required = false) String mail,
			@RequestParam(required = false) String mdp, Model model) {
		
	
	
		
		if (mail != null || mdp != null) {
			Civil civil = civildao.checklogin(mail, mdp);
			model.addAttribute("civil", civil);
			if (civil != null) {
				// Connexion � la session civil
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
