package com.myshop.fundamentals;

import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.repository.ApplicationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class FundamentalsApplication {
	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ApplicationRepository applicationRepository){
		return (args -> {
			applicationRepository.save(new Application("Google","Web Browser","James"));
			applicationRepository.save(new Application("Pegasus","File manager System","xad"));
			applicationRepository.save(new Application("Time reporter","Reporter time","Time R."));

			for (Application application:applicationRepository.findAll()) {
				System.out.println(application.toString());
			}
		});


	}
}
