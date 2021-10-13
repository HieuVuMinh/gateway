package com.example.bdsapigateway.modelDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private String Id;

    private double price;

    private String surface_area;

    private double bedroom;

    private String address;
}
