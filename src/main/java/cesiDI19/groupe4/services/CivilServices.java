package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Civil;
import cesiDI19.groupe4.dao.CivilDao;

@Component
public class CivilServices {
	@Autowired
	CivilDao civildao;
	
	public Civil getCivil() {
	List <Civil> listCivil = civildao.getAllCivils(0, 20);
		if (listCivil != null && listCivil.size()>0){
			return listCivil.get(0);
		} else {
			return null;
		}
	}
}
