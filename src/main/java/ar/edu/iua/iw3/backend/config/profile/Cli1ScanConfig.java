package ar.edu.iua.iw3.backend.config.profile;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//Repositorios
@EnableJpaRepositories(basePackages = "ar.edu.iua.iw3.backend",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "ar\\.edu\\.iua\\.iw3\\.backend\\.integration\\.cli2\\..*" )
                //Se pueden definir más filtros de exclusión
                //,@ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\.magm\\.backend\\.integration\\.cliN\\..*" )
        })


//Entidades
@EntityScan(basePackages = {
        "ar.edu.iua.iw3.backend.model",
        "ar.edu.iua.iw3.backend.auth",
        "ar.edu.iua.iw3.backend.integration.cli1.model"
},
        basePackageClasses = {
                // Se pueden cargar entidades particulares que no estén en los paquetes base
                //org.magm.backend.integration.cliN.model.Entidad1.class,
                //org.magm.backend.integration.cliN.model.Entidad2.class
        })
//Las dos líneas que siguen son equivalentes, se puede usar cualquiera
@ConditionalOnExpression(value = "'${spring.profiles.active:-}'=='cli1'") //<-- SpEL
@Profile("cli1")
public class Cli1ScanConfig {

}