package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
