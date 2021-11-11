package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.OrderItem;

public interface RepairService {
    public long saveRepair(RepairDTO repairDTO,CarDTO carDTO);

    public void saveOrderItem(RepairDTO repairDTO, PartDTO partDTO);


}
