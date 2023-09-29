package ar.edu.iua.iw3.backend.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.FoundException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.model.Category;

import java.util.List;

public interface ICategoryBusiness {
    public Category getById(long id) throws NotFoundException, BusinessException;

    public Category getByCategory(String category) throws NotFoundException, BusinessException;

    public List<Category> getCategories() throws BusinessException;

    public Category add(Category category) throws FoundException, BusinessException;

    public Category update(Category category) throws FoundException, NotFoundException, BusinessException;

    public void delete(long id) throws NotFoundException, BusinessException;
}
