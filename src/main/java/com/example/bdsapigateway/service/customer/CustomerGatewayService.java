package com.example.bdsapigateway.service.customer;

import com.example.bdsapigateway.modelDTO.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerGatewayService implements ICustomerGatewayService{

    @Autowired
    private Environment environment;

    public WebClient webClient = WebClient.create();

    @Override
    public Mono<Customer> createCustomer(Customer customer) {
        return webClient.post()
                .uri(environment.getProperty("BASE_URL_CUSTOMER") + "/customers")
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @Override
    public Flux<Customer> findAllCustomer() {
        return webClient.get()
                .uri( environment.getProperty("BASE_URL_CUSTOMER") + "/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Flux<Customer> findCustomerByAgentId(Long id) {
        return webClient.get()
                .uri( environment.getProperty("BASE_URL_CUSTOMER") + "/customers/agent/" + id)
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Flux<Customer> findCustomerHaveNoAssistance() {
        return webClient.get()
                .uri(environment.getProperty("BASE_URL_CUSTOMER") + "/customers/agent")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Mono<Customer> updateCustomerAssistanceByAgent(String id, Customer customer) {
        return webClient.put()
                .uri(environment.getProperty("BASE_URL_CUSTOMER") + "/customers/" + id)
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @Override
    public Mono<Customer> findCustomerById(String id) {
        return webClient.get()
                .uri(environment.getProperty("BASE_URL_CUSTOMER") + "/customers/" + id)
                .retrieve()
                .bodyToMono(Customer.class);
    }


}
