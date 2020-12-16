package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Organisation;
import cesiDI19.groupe4.dao.OrganisationDao;

@Component
public class OrganisationServices {
	@Autowired
	OrganisationDao organisationdao;
	
	public Organisation getOrganisation() {
	List <Organisation> listOrganisation = organisationdao.getAllOrganisations(0, 20);
		if (listOrganisation != null && listOrganisation.size()>0){
			return listOrganisation.get(0);
		} else {
			return null;
		}
	}
}
