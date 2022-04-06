package net.seyfe.waamainlab;

import org.modelmapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class WaamainlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaamainlabApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
