package ar.edu.iua.iw3.backend.config.profile;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ar.edu.iua.iw3.backend",
        excludeFilters = {
        })


//Entidades
@EntityScan(basePackages = {
        "ar.edu.iua.iw3.backend.model",
        "ar.edu.iua.iw3.backend.auth",
        "ar.edu.iua.iw3.backend.integration.cli1.model",
        "ar.edu.iua.iw3.backend.integration.cli2.model"
})

@Profile("mysqlnube")
public class MysqlnubeScanConfig {

}