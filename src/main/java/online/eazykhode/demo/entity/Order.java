package online.eazykhode.demo.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "orders")
@Data
public class Order{
	@Id
    String id;
    Long customerId;
    Instant orderDate;
    BigDecimal totalAmount;
}
