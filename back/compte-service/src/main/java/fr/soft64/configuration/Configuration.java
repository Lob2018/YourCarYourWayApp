package fr.soft64.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("compte-service")
@org.springframework.context.annotation.Configuration
public class Configuration {
	
	private String appAuthTokenIssuer;

	public String getTokenIssuer() {
		return appAuthTokenIssuer;
	}

	public void setTokenIssuer(String value) {
		this.appAuthTokenIssuer = value;
	}

}
