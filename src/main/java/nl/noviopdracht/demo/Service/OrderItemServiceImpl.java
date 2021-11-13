package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.OrderItemDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.OrderItemRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveOrderItem(RepairDTO repairDTO, PartDTO partDTO, OrderItemDTO orderItemDTO){
        //Repair repair = new Repair(repairDTO.getRepID(),repairDTO.isRepairComfirm(),repairDTO.isPaymentComfirm(),repairDTO.getNotes(),repairDTO.getUseditems());
        OrderItem orderItem = new OrderItem(orderItemDTO.getPartId(),partDTO.getPrice());
        // OrderItem orderItem = new OrderItem(partDTO.getId(),partDTO.getPrice());
//        OrderItem orderItem = new OrderItem(repairRepository.getById((long) repairDTO.getRepID()),partDTO.getId(),partDTO.getPrice());
        orderItemRepository.save(orderItem);

    }
}
