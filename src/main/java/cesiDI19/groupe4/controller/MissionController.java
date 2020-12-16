package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Mission;
import cesiDI19.groupe4.services.MissionServices;

@Controller
public class MissionController {
	
	@Autowired
	MissionServices missionServices;
	
	@RequestMapping("/mission")
    public String mission(@RequestParam(required = false, defaultValue = "World")
                           String name, Model model){
		Mission mission = missionServices.getMission();
		model.addAttribute("mission",mission);
		
        return "mission";
    }
}