package tn.sgsm.sgsmapp.Services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.entity.EtatPanne;
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
			panne.setEtatPanne(EtatPanne.EnPanne);
			panne.setDate(new Date());
			panne.setAscenseur(ascenseurs);	
			panneRepository.save(panne);
				
			return new MessageResponse(true, "panne declarer","");
		}
		
		public Panne getPanneById(int id) {
			
			Panne panne = panneRepository.findPanneByAscenseurId(id);
			
			return panne;
		}
		public List<Panne> getAllPanne(int id) {
			
			List<Panne> panne = panneRepository.findAllPanneByAscenseurId(id);
			
			return panne;
		}
	public Panne getlastPanne(int id) {
			
			Panne panne = panneRepository.findFirstByOrderByDateDesc(id);
			
			return panne;
		}
	
	public List<Panne> getAllPannes(){
		return panneRepository.findAll();
	}
	
	public Client getClientByIdAsc(int id) {
		Client client = ascenseurRepository.findById(id).get().getClient();
		return client;
	}
	
	
}
