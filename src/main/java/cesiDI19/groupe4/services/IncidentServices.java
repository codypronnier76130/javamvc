package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Incident;
import cesiDI19.groupe4.dao.IncidentDao;

@Component
public class IncidentServices {
	@Autowired
	IncidentDao incidentdao;
	
	public Incident getIncident() {
	List <Incident> listIncident = incidentdao.getAllIncident(0, 20);
		if (listIncident != null && listIncident.size()>0){
			return listIncident.get(0);
		} else {
			return null;
		}
	}
}
