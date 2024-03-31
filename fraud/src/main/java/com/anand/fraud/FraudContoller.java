package com.anand.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudContoller {

    private final FraudCheckService fraudCheckService;


    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService
                .isFradulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

    @GetMapping
    public FraudCheckResponse check(){
        return new FraudCheckResponse(false);
    }
}
