package ar.edu.iua.iw3.backend.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.FoundException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.model.Category;
import ar.edu.iua.iw3.backend.persistance.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryBusiness implements ICategoryBusiness {

    @Autowired
    private CategoryRepository repositoryDAO;

    @Override
    public Category getById(long id) throws NotFoundException, BusinessException {
        Optional<Category> category;

        try {
            category = repositoryDAO.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (category.isEmpty()) {
            throw NotFoundException.builder().message("No se ha encontrado el category ID: " + id).build();
        }

        return category.get();
    }

    @Override
    public Category getByCategory(String categoryName) throws NotFoundException, BusinessException {
        Optional<Category> category;

        try {
            category = repositoryDAO.findOneByCategory(categoryName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (category.isEmpty()) {
            throw NotFoundException.builder().message("No se ha encontrado el category de nombre: " + categoryName).build();
        }

        return category.get();
    }

    @Override
    public List<Category> getCategories() throws BusinessException {
        try {
            return repositoryDAO.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public Category add(Category category) throws FoundException, BusinessException {
        try {
            getById(category.getId());
            throw FoundException.builder().message("El category con ID: " + category.getId() + " ya existe.").build();
        } catch (NotFoundException e) {

        }
        try {
            getByCategory(category.getCategory());
            throw FoundException.builder().message("El category con nombre: " + category.getCategory() + " ya existe.").build();
        } catch (NotFoundException e) {

        }

        try {
            return repositoryDAO.save(category);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public Category update(Category category) throws FoundException, NotFoundException, BusinessException {
        getById(category.getId());

        Optional<Category> productFound;

        try {
            productFound = repositoryDAO.findOneByCategoryAndIdNot(category.getCategory(), category.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (productFound.isPresent()) {
            throw FoundException.builder().message("El category con nombre: " + category.getCategory() + " ya existe.").build();
        }

        try {
            return repositoryDAO.save(category);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public void delete(long id) throws NotFoundException, BusinessException {
        getById(id);

        try {
            repositoryDAO.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }
}
