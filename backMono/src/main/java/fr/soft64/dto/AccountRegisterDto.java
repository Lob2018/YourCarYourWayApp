package fr.soft64.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountRegisterDto {

	@NotNull
	@Size(max = 384)
	private String email;

	@NotNull
	@Size(max = 80)
	private String accountpassword;
	
	@Size(max = 256)
	private String accountname;

	// Getters and setters with Lombock
}