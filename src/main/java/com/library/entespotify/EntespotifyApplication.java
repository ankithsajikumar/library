package com.library.entespotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.library.entespotify")
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class EntespotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntespotifyApplication.class, args);
	}

}
