package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.ActionDTO;
import nl.noviopdracht.demo.DTO.OrderItemDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;

public interface OrderItemService {


    public void saveOrderItem(RepairDTO repairDTO, PartDTO partDTO, OrderItemDTO orderItemDTO, ActionDTO actionDTO);

}
