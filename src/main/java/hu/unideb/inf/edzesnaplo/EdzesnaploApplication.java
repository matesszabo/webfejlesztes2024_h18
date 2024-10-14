package hu.unideb.inf.edzesnaplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EdzesnaploApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdzesnaploApplication.class, args);
	}

}
