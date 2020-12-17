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
	
	@RequestMapping("mission")
	public String showform(Model m) {
		m.addAttribute("command", new Mission());
		return "mission";
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("mission") Mission mission) {
		dao.save(mission);
		return "redirect:/viewmission"; //redirige vers viewmission request mapping
	}
	
	@RequestMapping("/viewmission")
	public String viewmission(Model m) {
		List<Mission> list=dao.getAllMissions();
		m.addAttribute("list", list);
		return "viewmission";
	}
	
	@RequestMapping(value="/editmission/{id}")
	public String edit(@PathVariable int id, Model m) {
		Mission mission = dao.getMissionById(id);
		m.addAttribute("command", mission);
		return "missionEdit";
	}
	
	@RequestMapping(value="/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("mission") Mission mission) {
		dao.update(mission);
		return "redirect:/viewmission";
	}
	
	@RequestMapping(value="/deletemission/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return"redirect:/viewmission";
	}
}
