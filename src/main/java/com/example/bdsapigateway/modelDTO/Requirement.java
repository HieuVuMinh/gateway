package com.example.bdsapigateway.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requirement {
    private double price;

    private String surfaceArea;

    private double bedroom;

    private String address;

    private String information;
}
