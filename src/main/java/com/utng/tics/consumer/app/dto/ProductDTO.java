package com.utng.tics.consumer.app.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String id;
    private String name;
    private Double price;
    private String categoryId;
}
