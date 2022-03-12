package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.*;

import java.util.ArrayList;

public interface OrderItemService {


    public void saveOrderItem(RepairDTO repairDTO, PartDTO partDTO, OrderItemDTO orderItemDTO, ActionDTO actionDTO);

    public ArrayList<OrderItemDTO> GetAllOrderItem();

}

