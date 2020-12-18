package cesiDI19.groupe4.services;

import java.util.List;

import cesiDI19.groupe4.bean.Heros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Vilain;
import cesiDI19.groupe4.dao.VilainDao;

@Component
public class VilainServices {
    @Autowired
    VilainDao vilaindao;

    public Vilain getVilains() {
        List <Vilain> listVilains = vilaindao.getAllVilains();
        if (listVilains != null && listVilains.size()>0){
            return listVilains.get(0);
        } else {
            return null;
        }
    }
}
