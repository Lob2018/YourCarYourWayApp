package fr.soft64.dto;

import java.util.UUID;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TchatUserDto {

	private UUID useruuid;

	@Size(max = 256)
	private String accountname;
	@Size(max = 256)
	private String surname;
	private boolean active = true;

}
