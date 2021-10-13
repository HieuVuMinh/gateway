package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.ResponseObject;
import com.example.bdsapigateway.service.agent.IAgentGatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/agents")
@Api(value="onlinestore", description="Demo API Agent")
public class AgentController {

    @Autowired
    private IAgentGatewayService agentGatewayService;


    @ApiOperation(value = "Thêm Agent",response = Agent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @PostMapping("")
    private ResponseEntity<?> createAgent(@RequestBody Agent agent){
        Agent agentObject = agentGatewayService.createAgent(agent).block();
        if(agentObject != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Thêm dữ liệu thành công!", agentObject)
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("Not Found","Thêm dữ liệu thất bại!", agentObject)
        );
    }


    @ApiOperation(value = "Lấy ra tất cả Agent",response = Agent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("")
    private Flux<Agent> findAllAgent(){
//        Flux<Agent> listAgent = agentGatewayService.findAllAgent();
//        if(listAgent != null){
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("OK","Trả dữ liệu thành công!", listAgent.publish())
//            );
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("Not Found","Agent không có dữ liệu!", listAgent)
//        );
        return agentGatewayService.findAllAgent();
    }


    @ApiOperation(value = "Tìm Agent theo id",response = Agent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Trả ra dữ liệu thành công!"),
            @ApiResponse(code = 401, message = "Xác thực thất bại!"),
            @ApiResponse(code = 403, message = "Cố tình truy cập trái phép!"),
            @ApiResponse(code = 404, message = "Không tồn tại!")
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Agent agent = agentGatewayService.findByAgentId(id).block();
        if(agent != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Trả dữ liệu thành công!", agent)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found","Agent không tồn tại!", agent)
        );
    }

}
