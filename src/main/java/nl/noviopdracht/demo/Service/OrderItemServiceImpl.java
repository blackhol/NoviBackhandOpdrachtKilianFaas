package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.*;
import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Repository.OrderItemRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final RepairRepository repairRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, RepairRepository repairRepository) {
        this.orderItemRepository = orderItemRepository;
        this.repairRepository = repairRepository;
    }


    @Override
    public void saveOrderItem(RepairDTO repairDTO, PartDTO partDTO, OrderItemDTO orderItemDTO, ActionDTO actionDTO){

        OrderItem orderItem = new OrderItem(orderItemDTO.getPartId(),orderItemDTO.getPrice(),orderItemDTO.getRepairID(),orderItemDTO.getActionId());
        orderItemRepository.save(orderItem);

    }

    @Override
    public ArrayList<OrderItemDTO> GetAllOrderItem() {
        List<OrderItem> orderitemsList = orderItemRepository.findAll();
        ArrayList<OrderItemDTO> orderItemDTOList = new ArrayList<OrderItemDTO>();

        for
        (
                OrderItem orderItem:orderitemsList
        )
        {
            OrderItemDTO orderitemconver = new OrderItemDTO();
            orderitemconver.setRepairID(orderItem.getRepairID());
            orderitemconver.setPartId(orderItem.getPartId());
            orderitemconver.setActionId(orderItem.getActionId());
            orderitemconver.setPrice(orderItem.getPrice());
            orderitemconver.setId(orderItem.getId());

            orderItemDTOList.add(orderitemconver);
        }

        return orderItemDTOList;

    }
}
