package fr.soft64.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TchatMessageDto {

	@NotNull
	private UUID tchatuuid;

	@NotNull
	private UUID sender_senderuuid;
	@NotNull
	private LocalDateTime createdat;
	@NotNull
	private LocalDateTime updatedat;
	private boolean active = true;
	@Size(max = 2048)
	private String content;

}
