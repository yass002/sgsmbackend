package tn.sgsm.sgsmapp.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="_panne")
public class Panne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	 @Column(name = "date_panne")
	private Date date ;
	
	private String descPanne;
	
	@Enumerated(EnumType.STRING)
	private EtatPanne etatPanne;
	
	@ManyToOne 
	@JoinColumn(name = "ascenseurId" , nullable = false )
	private Ascenseur ascenseur;
	

}
