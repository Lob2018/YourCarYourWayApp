package fr.soft64.configuration;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties("app.auth")
@org.springframework.context.annotation.Configuration
public class Configuration {

//	  @Value("${app.auth.tokenExpirationMsec}")
	   private String tokenExpirationMsec;

	public String getTokenExpirationMsec() {
		return "TEST SANS RECUPERATION";
	}

	public void setTokenExpirationMsec(String value) {
		this.tokenExpirationMsec = value;
	}

}
