package cesiDI19.groupe4.controller;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Heros;
import cesiDI19.groupe4.services.HeroService;

import java.util.List;

@Controller
public class HeroController {

    @Autowired
    HeroService heroService;

    @RequestMapping("/hero")
    public String hero(@RequestParam(required = false, defaultValue = "World")
                               String name, Model model){
        Heros heros = heroService.getHeros();
        model.addAttribute("heros",heros);



        return "hero";
    }


}

