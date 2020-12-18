package cesiDI19.groupe4.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value="/accueil")
	public String accueil(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		Object Id = session.getAttribute("Id");
		if (Id != null) {
			Civil civil = civildao.getCivilById((Integer) Id);
			m.addAttribute("civil", civil);
			return "accueil";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value="/modifprofil")
	public String modif(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		Object Id = session.getAttribute("Id");
		Civil civil = civildao.getCivilById((Integer) Id);
		m.addAttribute("civil", civil);
		return "modifprofil";
	}

	@RequestMapping(value="/validmodif", method = RequestMethod.POST)
	public String validmodif(HttpServletRequest request, @ModelAttribute("civil") Civil civil) {
		HttpSession session = request.getSession();
		Object Id = session.getAttribute("Id");
		civil.setId((Integer) Id);
		civildao.update(civil);
		return "redirect:/accueil";
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
				return "redirect:/accueil";
			} else {
				// Erreur de connexion
				model.addAttribute("erreurMessage", "login ou mot de passe incorrect");
			}
		}
		return "login";

	}

}
