package ar.edu.iua.iw3.backend.persistance;

import ar.edu.iua.iw3.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProduct(String product);
}
