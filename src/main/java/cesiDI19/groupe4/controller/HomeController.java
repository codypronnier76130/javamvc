package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Civil;
import cesiDI19.groupe4.bean.Organisation;
import cesiDI19.groupe4.services.CivilServices;
import cesiDI19.groupe4.services.OrganisationServices;

@Controller
public class HomeController {
	
	@Autowired
	CivilServices civilServices;
	OrganisationServices organisationServices;
	
	@RequestMapping("/home")
    public String home(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		Civil civil = civilServices.getCivil();
		model.addAttribute("civil",civil);
		Organisation organisation = organisationServices.getOrganisation();
		model.addAttribute("organisation",organisation);
		
		
		
        return "home";
    }
}

