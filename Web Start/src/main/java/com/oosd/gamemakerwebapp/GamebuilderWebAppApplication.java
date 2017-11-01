package com.oosd.gamemakerwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.oosd.gamemakerwebapp.gamestore")
@SpringBootApplication
public class GamebuilderWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamebuilderWebAppApplication.class, args);
	}
}
