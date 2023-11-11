package fr.soft64.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TchatUserDto {

	@NotNull
	@Size(max = 256)
	private String username;

	@NotNull
	@Size(max = 256)
	private String companyname;

}