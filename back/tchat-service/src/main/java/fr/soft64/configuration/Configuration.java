package fr.soft64.configuration;

import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Value("${spring.datasource.url}")
	private String datasourceURL;

	public String getdatasourceURL() {
		return datasourceURL;
	}

	public void setdatasourceURL(String value) {
		this.datasourceURL = value;
	}

}