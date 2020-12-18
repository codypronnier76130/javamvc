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


    @RequestMapping("/listHeros")
    public String listHeros(Model m) {
        List<Heros> list=dao.getAllHeros();
        m.addAttribute("list", list);
        return "listHero";
    }


    @RequestMapping("/formHero")
    public String formHero(Model m) {
        Heros hero = new Heros();
        //TODO Récupérer la requête


        m.addAttribute("hero", hero);
        return "fromHero";
    }

    @RequestMapping(value ="/createHero", method = RequestMethod.POST)
    public String createHero(HttpServletRequest request,@ModelAttribute("hero") Heros hero) {
        HttpSession session = request.getSession();

        dao.createHero((Integer) session.getAttribute("Id"),hero);
        return "redirect:/listHeros"; //redirige vers viewmission request mapping
    }

    @RequestMapping(value="/updateHeroForm/{id}")
    public String updateHero(@PathVariable int id, Model m) {
        Heros hero = dao.getSuperById(id);
        m.addAttribute("hero", hero);
        return "updateHero";
    }

    @RequestMapping(value="/updateHero", method = RequestMethod.POST)
    public String updateHero(@ModelAttribute("hero") Heros hero) {
        dao.updateHero(hero);
        return "redirect:/listHeros";
    }




}

