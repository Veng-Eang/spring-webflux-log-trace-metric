package online.eazykhode.demo.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.eazykhode.demo.entity.Order;
import online.eazykhode.demo.repository.OrderRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderRepository orderRepository;

    @GetMapping("/{id}")
    public Mono<Order> findById(@PathVariable String id) {
        return orderRepository.findById(id)
        			.switchIfEmpty(Mono.empty());
    }
    
    @GetMapping
    public Flux<Order> findByAll() {
        return orderRepository.findAll();
    }
    
    @PostMapping
    public Mono<Order> createOrder() {
    	Order order = new Order();
    	order.setCustomerId(1L);
    	order.setOrderDate(Instant.now());
    	order.setTotalAmount(BigDecimal.TEN);
        return orderRepository.save(order)
        			.switchIfEmpty(Mono.empty());
    }
}
