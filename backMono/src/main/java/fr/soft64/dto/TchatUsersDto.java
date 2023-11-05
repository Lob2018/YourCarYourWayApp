package fr.soft64.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TchatUsersDto {
	
	private TchatUserDto me;
	private TchatUserDto[] others;

}
