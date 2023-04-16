package tn.sgsm.sgsmapp.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sgsm.sgsmapp.entity.*;


public interface UserRepository extends JpaRepository<Client, Integer>{

	Optional<Client> findByEmail(String email);
	
}
