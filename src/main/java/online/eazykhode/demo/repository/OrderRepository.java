package online.eazykhode.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import online.eazykhode.demo.entity.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
