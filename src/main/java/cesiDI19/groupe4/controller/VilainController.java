package cesiDI19.groupe4.controller;

import cesiDI19.groupe4.bean.Heros;
import cesiDI19.groupe4.dao.VilainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Vilain;
import cesiDI19.groupe4.services.VilainServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VilainController {

    @Autowired
    VilainDao dao;

    @RequestMapping("/listVilains")
    public String listVilains(Model m) {
        List<Vilain> list=dao.getAllVilains();
        m.addAttribute("list", list);
        return "listVilain";
    }

    @RequestMapping("/formVilain")
    public String formVilain(Model m) {
        Vilain vilain = new Vilain();
        //TODO Récupérer la requête


        m.addAttribute("vilain", vilain);
        return "fromVilain";
    }

    @RequestMapping(value ="/createVilain", method = RequestMethod.POST)
    public String createVilain(HttpServletRequest request, @ModelAttribute("vilain") Vilain vilain) {
        HttpSession session = request.getSession();

        dao.createVilains(vilain);
        return "redirect:/listVilains"; //redirige vers viewmission request mapping
    }
}

