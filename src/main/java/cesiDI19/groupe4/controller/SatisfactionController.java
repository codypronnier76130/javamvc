package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Satisfaction;
import cesiDI19.groupe4.services.SatisfactionServices;

@Controller
public class SatisfactionController {
	
	@Autowired
	SatisfactionServices satisfactionServices;
	
	@RequestMapping("/satisfaction")
    public String satisfaction(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		Satisfaction satisfaction = satisfactionServices.getSatisfaction();
		model.addAttribute("satisfaction",satisfaction);
		
        return "satisfaction";
    }
}
