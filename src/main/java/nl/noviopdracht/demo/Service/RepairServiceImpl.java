package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repos;
    private final CarRepository carRepository;
    private final RepairRepository repairRepository;

    @Autowired
    public RepairServiceImpl(RepairRepository repos, CarRepository carRepository, RepairRepository repairRepository) {
        this.repos = repos;
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
    }

    @Override
    public long saveRepair(RepairDTO repairDTO, CarDTO carDTO) {
        Repair repair = new Repair(carRepository.getById(carDTO.getCarID()),repairDTO.isRepairComfirm(),repairDTO.isPaymentComfirm(),repairDTO.getNotes(),repairDTO.getUseditems());
        repos.save(repair);

        return (long) repair.getRepID();
    }
    @Override
    public void saveOrderItem( RepairDTO repairDTO, PartDTO partDTO){
        OrderItem orderItem = new OrderItem(repairRepository.getById((long) repairDTO.getRepID()),partDTO.getId(),partDTO.getPrice());
       // repos.save(orderItem);

    }
}
