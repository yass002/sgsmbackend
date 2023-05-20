package tn.sgsm.sgsmapp.entity;





import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="_ascenseur")
public class Ascenseur {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String marque;
	
	private String ref;
	
	private String imageName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idClient", nullable=false)
    private Client client;
	
	@OneToMany ( targetEntity = Panne.class , mappedBy = "ascenseur" , cascade = CascadeType.ALL )
	@JsonBackReference
	private List<Panne> panne = new ArrayList<>();
	
}
