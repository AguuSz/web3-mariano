package ar.edu.iua.iw3.backend.integration.cli1.model;

import ar.edu.iua.iw3.backend.business.ICategoryBusiness;
import ar.edu.iua.iw3.backend.exceptions.BusinessException;
import ar.edu.iua.iw3.backend.exceptions.NotFoundException;
import ar.edu.iua.iw3.backend.util.DeserializerConstants;
import ar.edu.iua.iw3.backend.util.JsonUtiles;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ProductCli1JsonDeserializer extends StdDeserializer<ProductCli1> {

    private static final long serialVersionUID = -3881285352118964728L;

    protected ProductCli1JsonDeserializer(Class<?> vc) {
        super(vc);
    }

    private ICategoryBusiness categoryBusiness;

    public ProductCli1JsonDeserializer(Class<?> vc, ICategoryBusiness categoryBusiness) {
        super(vc);
        this.categoryBusiness = categoryBusiness;
    }

    @Override
    public ProductCli1 deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        ProductCli1 r = new ProductCli1();
        JsonNode node = jp.getCodec().readTree(jp);

        String code = JsonUtiles.getString(node, DeserializerConstants.DEFAULT_CODES,
                System.currentTimeMillis() + "");
        String productDesc = JsonUtiles.getString(node,
                DeserializerConstants.DEFAULT_DESCRIPTIONS, null);
        double price = JsonUtiles.getDouble(node, DeserializerConstants.DEFAULT_PRICES, 0);
        boolean stock = JsonUtiles.getBoolean(node, DeserializerConstants.DEFAULT_STOCKS, false);
        r.setCodCli1(code);
        r.setProduct(productDesc);
        r.setPrice(price);
        r.setStock(stock);
        String categoryName = JsonUtiles.getString(node, DeserializerConstants.DEFAULT_CATEGORIES, null);
        if (categoryName != null) {
            try {
                r.setCategory(categoryBusiness.getByCategory(categoryName));
            } catch (NotFoundException | BusinessException e) {
            }
        }
        return r;
    }

}
