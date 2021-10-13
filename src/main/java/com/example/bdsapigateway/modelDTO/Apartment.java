package com.example.bdsapigateway.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

private double price;

private String type_apartment;

private double bedroom;

private String bathroom;

private String surface_area;

private String address;

private String information;
}
