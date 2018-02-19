package com.iqmsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ArtemisConfig {
	
	@Autowired
	private ArtemisProperties artemisProperties;
	
	@Bean
	public ArtemisConfigurationCustomizer customizer() {
		return new ArtemisConfigurationCustomizer() {

			@Override
			public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
				try {
					configuration.addAcceptorConfiguration("netty", "tcp://localhost:" + artemisProperties.getPort());
											

					
				} catch (Exception e) {
					throw new RuntimeException("Failed to add netty transport acceptor to artemis instance", e);
				}

			}

		};
	}

}
