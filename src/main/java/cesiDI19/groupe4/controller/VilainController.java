package cesiDI19.groupe4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cesiDI19.groupe4.bean.Vilain;
import cesiDI19.groupe4.services.VilainServices;

@Controller
public class VilainController {

    @Autowired
    VilainServices vilainServices;

    @RequestMapping("/vilain")
    public String vilain(@RequestParam(required = false, defaultValue = "World")
                               String name, Model model){
        Vilain vilains = vilainServices.getVilains();
        model.addAttribute("vilains",vilains);



        return "vilain";
    }
}

