package fr.soft64.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Autowired
	AuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("compte", r -> r.path("/endpoint").filters(f -> f.filter(filter)).uri("lb://compte"))

				.route("compte", r -> r.path("/compte/**").filters(f -> f.filter(filter)).uri("lb://compte"))
				.route("tchat", r -> r.path("/tchat/**").filters(f -> f.filter(filter)).uri("lb://tchat"))
				.build();
	}
}
