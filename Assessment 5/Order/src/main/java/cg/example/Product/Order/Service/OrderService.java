package cg.example.Product.Order.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cg.example.Product.Order.DTO.OrderResponse;
import cg.example.Product.Order.DTO.Product;
import cg.example.Product.Order.DTO.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "Order", fallbackMethod = "fallbackOrder")
    public OrderResponse createOrder(int userId, int productId, int quantity) {

        User user = restTemplate.getForObject(
                "http://USER/users/" + userId, User.class);

        Product product = restTemplate.getForObject(
                "http://PRODUCT/products/" + productId, Product.class);

        return new OrderResponse(
                5001,
                user.getName(),
                product.getName(),
                quantity,
                quantity * product.getPrice()
        );
    }
    public OrderResponse fallbackOrder(int userId, int productId, int quantity, Exception ex) {

        return new OrderResponse(
                0,
                "Service Unavailable",
                "Service Unavailable",
                quantity,
                0
        );
    }
}
    