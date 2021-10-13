package com.example.bdsapigateway.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    private  Long id;

    private String firstName;

    private String lastName;

    private String suportType;

    private Long customerId;
}
