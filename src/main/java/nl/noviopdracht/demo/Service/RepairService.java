package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;

public interface RepairService {
    public void saveRepair(RepairDTO repairDTO,CarDTO carDTO);
}
