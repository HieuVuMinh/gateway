package com.example.bdsapigateway.service.customer;

import com.example.bdsapigateway.modelDTO.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerGatewayService {

    Mono<Customer> createCustomer(Customer customer);

    Flux<Customer> findAllCustomer();

    Flux<Customer> findCustomerByAgentId(Long id);

    Flux<Customer> findCustomerHaveNoAssistance();

    Mono<Customer> updateCustomerAssistanceByAgent(String id, Customer customer);

    Mono<Customer> findCustomerById(String id);


}
