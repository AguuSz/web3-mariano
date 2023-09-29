package ar.edu.iua.iw3.backend.persistance;

import ar.edu.iua.iw3.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findOneByCategory(String category);
}
