package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cesiDI19.groupe4.bean.Incident;
import cesiDI19.groupe4.dao.IncidentDao;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IncidentController {

	@Autowired
	IncidentDao dao;

	//Route vers l'ajout d'un incident
	@RequestMapping("incident")
	public String showform(Model m) {
		Incident incident = new Incident();
		//TODO Récupérer la requête
		incident.setId_mission(1);

		m.addAttribute("incident", incident);
		return "incident";
	}

	//Redirection vers la page de la liste des incidents une fois l'ajout d'un incident
	@RequestMapping(value ="/saveincident", method = RequestMethod.POST)
	public String saveincident(@ModelAttribute("incident") Incident incident) {
		dao.saveincident(incident);
		return "redirect:/viewincident"; //redirige vers viewmission request mapping
	}

	//Route vers la liste des incidents
	@RequestMapping("/viewincident")
	public String viewincident(Model m) {
		List<Incident> list=dao.getAllIncident();
		m.addAttribute("list", list);
		return "viewincident";
	}

	//Modification de l'incident sélectionné via l'Id de celle-ci
	@RequestMapping(value="/editincident/{id}")
	public String edit(@PathVariable int id, Model m) {
		Incident incident = dao.getIncidentById(id);
		m.addAttribute("incident", incident);
		return "incidentEdit";
	}

	//Redirection vers la liste des incidents, une fois la modification de l'incident via son ID
	@RequestMapping(value="/editsaveincident", method = RequestMethod.POST)
	public String editsaveincident(@ModelAttribute("incident") Incident incident) {
		dao.update(incident);
		return "redirect:/viewincident";
	}

	//Redirection vers la liste des incidents, une fois la suppression de l'incident sélectionné
	@RequestMapping(value="/deleteincident/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return"redirect:/viewincident";
	}
}
