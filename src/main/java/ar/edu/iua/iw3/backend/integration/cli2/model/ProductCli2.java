package ar.edu.iua.iw3.backend.integration.cli2.model;

import ar.edu.iua.iw3.backend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cli2_products")
@PrimaryKeyJoinColumn(name = "id_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCli2 extends Product {


    @Column(nullable = false)
    private Date expirationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cli2_product_component",
            joinColumns = { @JoinColumn(name = "id_product", referencedColumnName = "id_product") },
            inverseJoinColumns = {	@JoinColumn(name = "id_component", referencedColumnName = "id") })
    private Set<ComponentCli2> components;

}

