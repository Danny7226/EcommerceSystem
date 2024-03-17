package com.ecommerceduo.product.model;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Document value specifies the collection/table of mongo database
 */
@Document(value = "product")
@Data
@Builder
@Setter
public class Product {
    @Id
    private String productId;
    @Version
    private Long version; // optimistic locking

    @Field(name = "title")
    private String productTitle;
    @Field(name = "description")
    private String productDescription;
    private BigDecimal price;
}
