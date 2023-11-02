package fr.soft64.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountLoginDto {

	@NotBlank
	@Size(max = 80)
	private String password;

	@NotBlank
	@Email
	@Size(max = 384)
	private String email;

}
