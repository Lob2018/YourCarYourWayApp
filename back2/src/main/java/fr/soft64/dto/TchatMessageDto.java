package fr.soft64.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import fr.soft64.model.Account;
import fr.soft64.model.Tchat;
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
public class TchatMessageDto {

	@NotNull
	private Tchat tchatuuid;

	@NotNull
	private Account useruuid;
	@NotNull
	private LocalDateTime createdat;
	@NotNull
	private LocalDateTime updatedat;
	private final boolean active = true;
	@Size(max = 2048)
	private String content;

}
