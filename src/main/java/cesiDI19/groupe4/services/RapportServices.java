package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Rapport;
import cesiDI19.groupe4.dao.RapportDao;

@Component
public class RapportServices {
	@Autowired
	RapportDao rapportdao;
	
	public Rapport getRapport() {
	List <Rapport> listRapport = rapportdao.getAllRapport(0, 20);
		if (listRapport != null && listRapport.size()>0){
			return listRapport.get(0);
		} else {
			return null;
		}
	}
}
