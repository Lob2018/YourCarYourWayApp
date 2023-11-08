package fr.soft64.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountLoginDto {

	@NotBlank
	@Size(max = 80)
	private String password;

	@NotBlank
	@Email
	@Size(max = 384)
	private String email;

}
