package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cesiDI19.groupe4.bean.Organisation;
import cesiDI19.groupe4.dao.OrganisationDao;

import java.util.List;

@Controller
public class OrganisationController {
	
	@Autowired
	OrganisationDao dao;
	
	@RequestMapping("/organisation")
    public String organisation(Model m) {
		Organisation organisation = new Organisation();
		//TODO RECUPERER LA REQUETE
		organisation.setId_civil(1);

		m.addAttribute("organisation", organisation);
		return "organisation";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("organisation") Organisation organisation) {
		dao.save(organisation);
		return "redirect:/vieworganisation";//redirige vers vieworganisation request mapping
	}

	@RequestMapping("/vieworganisation")
	public String vieworganisation(Model m) {
		List<Organisation> list = dao.getAllOrganisations();
		m.addAttribute("list", list);
		return "vieworganisation";
	}

	@RequestMapping(value= "/editorganisation/{id}")
	public String edit(@PathVariable int id, Model m) {
		Organisation organisation = dao.getOrganisationById(id);
		m.addAttribute("organisation", organisation);
		return "organisationEdit";
	}

	@RequestMapping(value="/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("organisation") Organisation organisation) {
		dao.update(organisation);
		return "redirect:/vieworganisation";
	}

	@RequestMapping(value="/deleteorganisation/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id){
		dao.delete(id);
		return"redirect:/vieworganisation";
		

    }
}