package fr.soft64.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TchatUsersDto {

	private TchatUserDto me;
	private TchatUserDto[] others;

}
