package ar.edu.iua.iw3.backend.controllers;

import ar.edu.iua.iw3.backend.business.IProductBusiness;
import ar.edu.iua.iw3.backend.util.IStandardResponseBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URL_PRODUCTS)
public class ProductController extends BaseRestController {
    @Autowired
    private IProductBusiness productBusiness;

    @Autowired
    private IStandardResponseBusiness response;

    public ResponseEntity<?> list() {
        try {
            return new ResponseEntity<>(productBusiness.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
