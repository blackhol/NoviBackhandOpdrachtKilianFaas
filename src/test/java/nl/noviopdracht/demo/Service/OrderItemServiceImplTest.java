package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Repository.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceImplTest {

    @Mock
    OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    @Captor
    ArgumentCaptor<OrderItem> orderItemCaptor;

    @Test
    void saveOrderItemTest() {
        //Arrange
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10);
        orderItem.setId(1);
        orderItemRepository.save(orderItem);
        //Act
        verify(orderItemRepository, times(1)).save(orderItemCaptor.capture());

        var orderItem1 = orderItemCaptor.getValue();
        //Assert
        assertThat(orderItem1.getId()).isEqualTo(1);
        assertThat(orderItem1.getPrice()).isEqualTo(10);

    }

    @Test
    void getAllOrderItemTest() {
        //Arrange
        List<OrderItem> orderItemstest = new ArrayList<>();
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setPrice(10);
        orderItem1.setId(1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setPrice(12);
        orderItem2.setId(2);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setPrice(13);
        orderItem3.setId(3);

        OrderItem orderItem4 = new OrderItem();
        orderItem4.setPrice(14);
        orderItem4.setId(4);

        orderItemstest.add(orderItem1);
        orderItemstest.add(orderItem2);
        orderItemstest.add(orderItem3);
        orderItemstest.add(orderItem4);
        //Act
        when(orderItemRepository.findAll()).thenReturn(orderItemstest);

        orderItemService.GetAllOrderItem();
        //Assert
        assertThat(orderItem1.getPrice()).isEqualTo(10);
        assertThat(orderItem1.getId()).isEqualTo(1);

        assertThat(orderItem2.getPrice()).isEqualTo(12);
        assertThat(orderItem2.getId()).isEqualTo(2);

        assertThat(orderItem3.getPrice()).isEqualTo(13);
        assertThat(orderItem3.getId()).isEqualTo(3);

        assertThat(orderItem4.getPrice()).isEqualTo(14);
        assertThat(orderItem4.getId()).isEqualTo(4);
    }
}