package fr.soft64.security;

import static java.lang.String.format;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {

	// The user's environment variables
	@Value("${app.auth.tokenSecret}")
	private String jwtSecret;
	@Value("${app.auth.tokenIssuer}")
	private String jwtIssuer;
	@Value("${app.auth.tokenExpirationMsec}")
	private int expiration;

	private final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);
	private final int expirationMiliseconds = expiration;

	public final String generateAccessToken(final User autendicatedUser) {
				return Jwts.builder().setSubject(format("%s", autendicatedUser.getUsername())).setIssuer(jwtIssuer)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expirationMiliseconds))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public final String getUsername(final String token) {
		final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject().split(",")[0];
	}

	public final Date getExpirationDate(final String token) {
		final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

	public final boolean validate(final String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature - {}", ex.getMessage());
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token - {}", ex.getMessage());
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token - {}", ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token - {}", ex.getMessage());
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty - {}", ex.getMessage());
		}
		return false;
	}
}