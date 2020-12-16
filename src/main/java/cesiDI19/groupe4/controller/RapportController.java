package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Rapport;
import cesiDI19.groupe4.services.RapportServices;


@Controller
public class RapportController {
	
	@Autowired
	RapportServices rapportServices;

	
	@RequestMapping("/rapport")
    public String home(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		Rapport rapport = rapportServices.getRapport();
		model.addAttribute("rapport", rapport);
		
        return "rapport";
    }
}