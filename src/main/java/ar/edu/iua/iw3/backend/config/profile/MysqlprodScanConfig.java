package ar.edu.iua.iw3.backend.config.profile;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.magm.backend", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "ar\\.edu\\.iua\\.iw3\\.backend\\.integration\\.cli1\\..*"),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "ar\\.edu\\.iua\\.iw3\\.backend\\.integration\\.cli2\\..*") })

//Entidades
@EntityScan(basePackages = { "ar.edu.iua.iw3.backend.model",
        "ar.edu.iua.iw3.backend.auth" })

@Profile("mysqlprod")
public class MysqlprodScanConfig {

}