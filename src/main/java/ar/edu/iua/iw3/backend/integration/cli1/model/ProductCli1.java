package ar.edu.iua.iw3.backend.integration.cli1.model;

import ar.edu.iua.iw3.backend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cl1_products")
@PrimaryKeyJoinColumn(name = "id_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCli1 extends Product {
    @Column(nullable = false, unique = true)
    private String codCli1;
}
