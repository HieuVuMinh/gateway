package com.example.bdsapigateway.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String customer_id;

    private String customer_name;

    private String customer_phone;

    private String customer_email;

    private List<Apartment> apartments;

    private List<Requirement> requirements;

    private Long agentId;
}
