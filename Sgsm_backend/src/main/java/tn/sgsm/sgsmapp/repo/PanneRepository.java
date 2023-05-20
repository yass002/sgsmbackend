package tn.sgsm.sgsmapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.sgsm.sgsmapp.entity.Panne;

public interface PanneRepository extends JpaRepository<Panne, Integer> {
	
	Panne findPanneByAscenseurId(int id);
	List<Panne> findAllPanneByAscenseurId(int id);
	
	
    @Query(value = "SELECT * FROM _panne  WHERE :id=_panne.ascenseur_id  ORDER BY date_panne DESC LIMIT 1", nativeQuery = true)
	Panne findFirstByOrderByDateDesc(@Param("id") int id);
}
