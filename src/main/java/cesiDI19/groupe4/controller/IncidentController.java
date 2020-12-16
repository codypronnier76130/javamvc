package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cesiDI19.groupe4.bean.Incident;
import cesiDI19.groupe4.services.IncidentServices;

@Controller
public class IncidentController {

	@Autowired
	IncidentServices incidentServices;
	
	
	@RequestMapping("/incident")
    public String incident(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		
		Incident incident = incidentServices.getIncident();
		model.addAttribute("incident",incident);

        return "incident";
    }
}
