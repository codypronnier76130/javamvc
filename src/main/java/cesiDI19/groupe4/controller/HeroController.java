package cesiDI19.groupe4.controller;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cesiDI19.groupe4.bean.Heros;
import cesiDI19.groupe4.services.HeroService;
import cesiDI19.groupe4.dao.HeroDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HeroController {

    @Autowired

    HeroDao dao;

    //Mapping pour aller sur la page liste héros
    @RequestMapping("/listHeros")
    public String listHeros(Model m) {
        List<Heros> list=dao.getAllHeros();
        m.addAttribute("list", list);
        return "listHero";
    }

    //Mapping pour aller sur la page pour s'inscrire comme héros
    @RequestMapping("/formHero")
    public String formHero(Model m) {
        Heros hero = new Heros();
        //TODO Récupérer la requête


        m.addAttribute("hero", hero);
        return "fromHero";
    }
    
    //Mapping pour création héros
    @RequestMapping(value ="/createHero", method = RequestMethod.POST)
    public String createHero(HttpServletRequest request,@ModelAttribute("hero") Heros hero) {
        HttpSession session = request.getSession();

        dao.createHero((Integer) session.getAttribute("Id"),hero);
        return "redirect:/listHeros"; //redirige vers viewmission request mapping
    }
    //Mapping pour update héros
    @RequestMapping(value="/updateHeroForm/{id_Super}")
    public String updateHero(@PathVariable int id_Super, Model m) {
        Heros hero = dao.getSuperById(id_Super);
        m.addAttribute("hero", hero);
        return "updateHero";
    }
    //Mapping pour valider update héros
    @RequestMapping(value="/updateHero", method = RequestMethod.POST)
    public String updateHero(@ModelAttribute("hero") Heros hero) {
        dao.updateHero(hero);
        return "redirect:/listHeros";
    }




}

