package ar.edu.iua.iw3.backend.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.FoundException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.model.Category;
import ar.edu.iua.iw3.backend.model.Product;
import ar.edu.iua.iw3.backend.persistance.CategoryRepository;
import ar.edu.iua.iw3.backend.persistance.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductBusiness implements IProductBusiness{

    @Autowired
    private ProductRepository productDAO;

    @Autowired
    private CategoryRepository categoryDAO;

    @Override
    public Product getById(long id) throws NotFoundException, BusinessException {
        Optional<Product> product;

        try {
            product = productDAO.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (product.isEmpty()) {
            throw NotFoundException.builder().message("No se ha encontrado el producto ID: " + id).build();
        }

        return product.get();
    }

    @Override
    public Product getByProduct(String productName) throws NotFoundException, BusinessException {
        Optional<Product> product;

        try {
            product = productDAO.findOneByProduct(productName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (product.isEmpty()) {
            throw NotFoundException.builder().message("No se ha encontrado el producto de nombre: " + productName).build();
        }

        return product.get();
    }

    @Override
    public List<Product> getProducts() throws BusinessException {
        try {
            return productDAO.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public Product add(Product product) throws FoundException, NotFoundException, BusinessException {
        try {
            getById(product.getId());
            throw FoundException.builder().message("El producto con ID: " + product.getId() + " ya existe.").build();
        } catch (Exception e) {

        }
        try {
            getByProduct(product.getProduct());
            throw FoundException.builder().message("El producto con nombre: " + product.getProduct() + " ya existe.").build();
        } catch (Exception e) {

        }

        // Checkeo si la categoria dada existe, si no, tiro una excepcion
        if (product.getCategory() != null) {
            Optional<Category> categoryFound;
            try {
                // Caso en el que se haya dado un ID de categoria
                if (product.getCategory().getId() != 0)
                    categoryFound = categoryDAO.findById(product.getCategory().getId());
                    // Caso en el que no se encuentre un ID (por default = 0), se intenta buscar por categoria
                else
                    categoryFound = categoryDAO.findOneByCategory(product.getCategory().getCategory());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw BusinessException.builder().ex(e).build();
            }

            if (categoryFound.isEmpty()) {
                if (product.getCategory().getId() != 0)
                    throw NotFoundException.builder().message("No se ha encontrado la categoría con ID: " + product.getCategory().getId()).build();
                else
                    throw NotFoundException.builder().message("No se ha encontrado la categoría: " + product.getCategory().getCategory()).build();
            }

            product.setCategory(categoryFound.get());
        }

        try {
            return productDAO.save(product);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public Product update(Product product) throws FoundException, NotFoundException, BusinessException {
        getById(product.getId());

        Optional<Product> productFound;

        try {
            productFound = productDAO.findByProductAndIdNot(product.getProduct(), product.getId());
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        if (productFound.isPresent()) {
            throw FoundException.builder().message("El producto con nombre: " + product.getProduct() + " ya existe.").build();
        }

        // Checkeo si la categoria dada existe, si no, tiro una excepcion
        if (product.getCategory() != null) {
            Optional<Category> categoryFound;
            try {
                // Caso en el que se haya dado un ID de categoria
                if (product.getCategory().getId() != 0)
                    categoryFound = categoryDAO.findById(product.getCategory().getId());
                // Caso en el que no se encuentre un ID (por default = 0), se intenta buscar por categoria
                else
                    categoryFound = categoryDAO.findOneByCategory(product.getCategory().getCategory());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw BusinessException.builder().ex(e).build();
            }

            if (categoryFound.isEmpty()) {
                if (product.getCategory().getId() != 0)
                    throw NotFoundException.builder().message("No se ha encontrado la categoría con ID: " + product.getCategory().getId()).build();
                else
                    throw NotFoundException.builder().message("No se ha encontrado la categoría: " + product.getCategory().getCategory()).build();
            }

            product.setCategory(categoryFound.get());
        }

        try {
            return productDAO.save(product);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

    @Override
    public void delete(long id) throws NotFoundException, BusinessException {
        getById(id);

        try {
            productDAO.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }
}
