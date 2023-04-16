package tn.sgsm.sgsmapp.entity;


import jakarta.persistence.Entity;
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
@Table(name="_ascenseur")
public class Ascenseur {
	@Id
	public int id;
	
	@ManyToOne
	@JoinColumn(name="idClient", nullable=false)
    private Client client;
	
}
