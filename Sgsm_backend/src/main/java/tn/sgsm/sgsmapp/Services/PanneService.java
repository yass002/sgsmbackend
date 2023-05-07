package tn.sgsm.sgsmapp.Services;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Panne;
import tn.sgsm.sgsmapp.repo.AscenseurRepository;
import tn.sgsm.sgsmapp.repo.PanneRepository;
import tn.sgsm.sgsmapp.response.MessageResponse;

@Service
@RequiredArgsConstructor
public class PanneService {

		private final PanneRepository panneRepository;
		private final AscenseurRepository ascenseurRepository;
		
		public MessageResponse ajoutPanne(Panne panne  , Integer id) {
			
			Ascenseur ascenseurs = ascenseurRepository.findById(id).get();
			
			panne.setDatePanne(new Date());
			panne.setAscenseur(ascenseurs);	
			panneRepository.save(panne);
				
			return new MessageResponse(true, "panne declarer","");
		}
	
	
}
