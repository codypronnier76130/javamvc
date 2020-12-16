  
package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Organisation;
import cesiDI19.groupe4.services.OrganisationServices;

@Controller
public class OrganisationController {
	
	@Autowired
	OrganisationServices organisationServices;
	
	@RequestMapping("/organisation")
    public String organisation(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		Organisation organisation = organisationServices.getOrganisation();
		model.addAttribute("organisation",organisation);
		
		
		
        return "organisation";
    }
}