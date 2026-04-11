package cg.example.Product.Order.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cg.example.Product.Order.DTO.OrderRequest;
import cg.example.Product.Order.DTO.OrderResponse;
import cg.example.Product.Order.Service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest req) {

        return service.createOrder(
        		 req.getUserId(),
                 req.getProductId(),
                 req.getQuantity()
        );
    }
}