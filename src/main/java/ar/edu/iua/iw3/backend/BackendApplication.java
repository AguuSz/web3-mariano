package ar.edu.iua.iw3.backend;

import ar.edu.iua.iw3.backend.business.IProductBusiness;
import ar.edu.iua.iw3.backend.model.Product;
import ar.edu.iua.iw3.backend.persistance.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class BackendApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Value("${spring.profiles.active:sinperfil}")
	private String profile;

	@Value("${spring.jackson.time-zone:-}")
	private String backendTimezone;

//	@Autowired
//	private IProductBusiness productBusiness;

	@Autowired
	private ProductRepository productDAO;

	@Autowired
	private PasswordEncoder pEncoder;

	@Override
	public void run(String... args) throws Exception {
		String tzId = backendTimezone.equals("-") ?   TimeZone.getDefault().getID() : backendTimezone;
		TimeZone.setDefault(TimeZone.getTimeZone(tzId));

		log.info("-------------------------------------------------------------------------------------------------------------------");
		log.info("- Initial TimeZone: {} ({})", TimeZone.getDefault().getDisplayName(), TimeZone.getDefault().getID());
		log.info("- Perfil activo {}",profile);
		log.info("-------------------------------------------------------------------------------------------------------------------");

//		log.info("Cantidad de productos de la categoría id=1: {}", productDAO.countProductsByCategory(1));
//		log.info("Set stock=true producto id que no existe, resultado={}", productDAO.setStock(true, 333));

		log.info("admin123 = {} ", pEncoder.encode("admin123"));
		log.info("user123 = {} ", pEncoder.encode("user123"));
	}
}
