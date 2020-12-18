package cesiDI19.groupe4.services;

import java.util.List;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Heros;
import cesiDI19.groupe4.dao.HeroDao;

@Component
public class HeroService {
    @Autowired
    HeroDao herodao;

    public Heros getHeros() {
        List <Heros> listHeros = herodao.getAllHeros();
        if (listHeros != null && listHeros.size()>0){
            return listHeros.get(0);
        } else {
            return null;
        }
    }



}
