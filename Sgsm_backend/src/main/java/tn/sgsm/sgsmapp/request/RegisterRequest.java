package tn.sgsm.sgsmapp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.sgsm.sgsmapp.entity.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String firstName;
	private String lastName;
	private String numTel;
	private String numFix;
	private String adresse;
	private String email;
	private String password;
	private Role role;
}
