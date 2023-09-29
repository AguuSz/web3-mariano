package ar.edu.iua.iw3.backend.integration.cli1.model.persistance;

import ar.edu.iua.iw3.backend.integration.cli1.model.ProductCli1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCli1Repository extends JpaRepository<ProductCli1, Long> {
    public Optional<ProductCli1> findOneByCodCli1(String codCli1);
}
