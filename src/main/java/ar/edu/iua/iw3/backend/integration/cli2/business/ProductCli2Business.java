package ar.edu.iua.iw3.backend.integration.cli2.business;

import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2;
import ar.edu.iua.iw3.backend.integration.cli2.model.persistence.IProductCli2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Profile({ "cli2", "mysqlprod" })
public class ProductCli2Business implements IProductCli2Business {

    @Autowired(required = false)
    private IProductCli2Repository productDAO;

    @Override
    public List<ProductCli2> listExpired(Date date) throws BusinessException {
        try {
            return productDAO.findByExpirationDateBeforeOrderByExpirationDateDesc(date);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
    }

}
