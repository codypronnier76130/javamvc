package cesiDI19.groupe4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("mission") Mission mission) {
		missionServices.save(mission);
		return "redirect:/viewmission"; //redirige vers viewmission request mapping
	}
	
	@RequestMapping("/viewmission")
	public String viewmission(Model m) {
		Mission mission = missionServices.getMission();
		m.addAttribute("mission", mission);
		return "viewmission";
	}
	
	@RequestMapping(value="editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("mission") Mission mission) {
		missionServices.update(mission);
		return "redirect:/viewmission";
	}
	
	@RequestMapping(value="deletemission/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		missionServices.delete(id);
		return"redirect:/viewmission";
	}
}
