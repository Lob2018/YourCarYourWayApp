package fr.soft64.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Component
public class JwtUtil {

	@Value("${YCYW_YL_SERVICE_COMPTE_TOKEN_SECRET}")
	private String secret;

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
	}

	private boolean isTokenExpired(String token) {
		return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
	}

	public boolean isInvalid(String token) {
		return this.isTokenExpired(token);
	}

}