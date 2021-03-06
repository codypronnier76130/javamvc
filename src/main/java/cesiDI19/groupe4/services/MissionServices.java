package cesiDI19.groupe4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Mission;
import cesiDI19.groupe4.dao.MissionDao;

@Component
public class MissionServices {
	@Autowired
	MissionDao missionDao;

	//Récupère la liste de toutes les missions
	public Mission getMission() {
	List <Mission> listMission = missionDao.getAllMissions();
		if (listMission != null && listMission.size()>0){
			return listMission.get(0);
		} else {
			return null;
		}
	}
}
