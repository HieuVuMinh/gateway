package com.example.bdsapigateway.service.agent;

import com.example.bdsapigateway.modelDTO.Agent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAgentGatewayService {

    Mono<Agent> createAgent(Agent agent);

    Flux<Agent> findAllAgent();

    Mono<Agent> findByAgentId(Long id);

}
