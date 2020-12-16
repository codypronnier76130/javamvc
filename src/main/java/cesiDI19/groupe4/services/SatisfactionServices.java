package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Satisfaction;
import cesiDI19.groupe4.dao.SatisfactionDao;

@Component
public class SatisfactionServices {
	@Autowired
	SatisfactionDao satisfactionDao;
	
	public Satisfaction getSatisfaction() {
	List <Satisfaction> listSatisfaction = satisfactionDao.getAllSatisfactions(0, 20);
		if (listSatisfaction != null && listSatisfaction.size()>0){
			return listSatisfaction.get(0);
		} else {
			return null;
		}
	}
}
