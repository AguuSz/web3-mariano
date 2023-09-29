package ar.edu.iua.iw3.backend.integration.cli2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cli2_components")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComponentCli2 implements Serializable {

    private static final long serialVersionUID = 5695618110757822325L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, unique = true)
    private String component;
}

