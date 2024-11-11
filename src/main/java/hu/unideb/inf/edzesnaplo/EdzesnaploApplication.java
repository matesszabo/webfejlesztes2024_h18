package hu.unideb.inf.edzesnaplo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EdzesnaploApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdzesnaploApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		ModelMapper m = new ModelMapper();

		return m;

		//return new ModelMapper();
	}

}
