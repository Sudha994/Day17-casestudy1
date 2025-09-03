package com.example.zipkinorderserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
	 private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	    private final RestTemplate restTemplate;

	    public OrderController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    @PostMapping
	    public String createOrder(@RequestBody String order) {
	        log.info("Order Service: Creating order for {}", order);

	        String paymentResponse = restTemplate.postForObject(
	                "http://localhost:8082/payment",
	                order,
	                String.class
	        );

	        log.info("Order Service: Payment Service responded: {}", paymentResponse);
	        return "Order placed successfully. " + paymentResponse;
	    }
	}


