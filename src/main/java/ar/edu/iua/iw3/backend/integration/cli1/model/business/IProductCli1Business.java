package ar.edu.iua.iw3.backend.integration.cli1.model.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.FoundException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.integration.cli1.model.ProductCli1;

import java.util.List;

public interface IProductCli1Business {
    public ProductCli1 load(String codCli1) throws NotFoundException, BusinessException;
    public List<ProductCli1> list() throws BusinessException;
    public ProductCli1 add(ProductCli1 product) throws FoundException, BusinessException;
    public ProductCli1 addExternal(String json) throws FoundException, BusinessException;

}
