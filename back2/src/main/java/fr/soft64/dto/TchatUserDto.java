package fr.soft64.dto;

import java.util.UUID;

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

	private UUID useruuid;

	@Size(max = 256)
	private String accountname;
	@Size(max = 256)
	private String surname;
	private final boolean active = true;

}
