package ar.edu.iua.iw3.backend.integration.cli2.model;

//https://docs.spring.io/spring-data/commons/docs/current/reference/html/#projections
public interface ProductCli2SlimView {
    Long getId();
    String getProduct();
    Double getPrice();

    Category getCategory(); //category

    interface Category {
        String getCategory();
		/*
		SubCategory getSubCategory();
		interface SubCategory {
			Date getDate();
			String getDescription();
		}
		*/
    }
}
/*
 * product.id
 * product.product
 * product.price
 * product.category.category
 */
