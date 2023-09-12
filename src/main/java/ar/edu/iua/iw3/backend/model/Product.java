package ar.edu.iua.iw3.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String product;

    @Column(columnDefinition = "tinyint default 1")
    private boolean stock=true;

    private double price;

    @Override
    public String toString() {
        return String.format("Product[id=%d, product='%s', stock='%s', price='%s']", getId(), getProduct(), isStock(), getPrice());
    }
}
