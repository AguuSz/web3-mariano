package ar.edu.iua.iw3.backend.integration.cli2.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2;

import java.util.Date;
import java.util.List;

public interface IProductCli2Business {
    public List<ProductCli2> listExpired(Date date) throws BusinessException;
}
