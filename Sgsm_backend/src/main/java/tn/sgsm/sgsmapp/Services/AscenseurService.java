package tn.sgsm.sgsmapp.Services;




import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.repo.AscenseurRepository;

@Service
@RequiredArgsConstructor
public class AscenseurService {
	
	private final AscenseurRepository ascenseurRepository;
	
	
	public Ascenseur getAscById(Integer id ) {
		
		return ascenseurRepository.findById(id).get();
		
	}

	
	

}
