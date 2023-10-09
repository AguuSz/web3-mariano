package ar.edu.iua.iw3.backend.integration.cli2.model.persistence;

import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2SlimView;

import java.util.Date;
import java.util.List;

public interface IProductCli2Repository {
    public List<ProductCli2> findByExpirationDateBeforeOrderByExpirationDateDesc(Date expirationDate);
    public List<ProductCli2SlimView> findByOrderByPriceDesc();
}
