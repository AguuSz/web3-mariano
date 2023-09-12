package ar.edu.iua.iw3.backend;

import ar.edu.iua.iw3.backend.business.IProductBusiness;
import ar.edu.iua.iw3.backend.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private IProductBusiness productBusiness;
	@Override
	public void run(String... args) throws Exception {

	}
}
