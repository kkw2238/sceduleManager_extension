package com.sparta.schedulemanager_extension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SceduleManagerExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SceduleManagerExtensionApplication.class, args);
	}

}
