package com.example.products.model;

import com.example.products.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "tb_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Integer price_in_cents;

}
