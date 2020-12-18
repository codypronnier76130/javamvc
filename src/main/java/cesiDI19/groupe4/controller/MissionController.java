package cesiDI19.groupe4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cesiDI19.groupe4.bean.Mission;
import cesiDI19.groupe4.dao.MissionDao;

@Controller
public class MissionController {
	
	@Autowired
	MissionDao dao;

	//Route vers l'ajout d'une fiche mission
	@RequestMapping("mission")
	public String showform(Model m) {
		Mission mission = new Mission();
		//TODO Récupérer la requête
		mission.setId_incident(1);

		m.addAttribute("mission", mission);
		return "mission";
	}

	//Redirection vers la page de la liste des missions une fois l'ajout d'une mission
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("mission") Mission mission) {
		dao.save(mission);
		return "redirect:/viewmission"; //redirige vers viewmission request mapping
	}

	//Route vers la liste des missions
	@RequestMapping("/viewmission")
	public String viewmission(Model m) {
		List<Mission> list=dao.getAllMissions();
		m.addAttribute("list", list);
		return "viewmission";
	}

	//Modification de la mission sélectionnée via l'Id de celle-ci
	@RequestMapping(value="/editmission/{id}")
	public String edit(@PathVariable int id, Model m) {
		Mission mission = dao.getMissionById(id);
		m.addAttribute("mission", mission);
		return "missionEdit";
	}

	//Redirection vers la liste des missions, une fois la modification de la mission via son ID
	@RequestMapping(value="/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("mission") Mission mission) {
		dao.update(mission);
		return "redirect:/viewmission";
	}

	//Redirection vers la liste des missions, une fois la suppression de la mission sélectionnée
	@RequestMapping(value="/deletemission/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return"redirect:/viewmission";
	}
}
