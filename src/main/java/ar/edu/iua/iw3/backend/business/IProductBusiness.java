package ar.edu.iua.iw3.backend.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.FoundException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.model.Product;

import java.util.List;

public interface IProductBusiness {
    public Product getById(long id) throws NotFoundException, BusinessException;

    public Product getByProduct(String product) throws NotFoundException, BusinessException;

    public List<Product> getProducts() throws BusinessException;

    public Product add(Product product) throws FoundException, NotFoundException, BusinessException;

    public Product update(Product product) throws FoundException, NotFoundException, BusinessException;

    public void delete(long id) throws NotFoundException, BusinessException;
}
