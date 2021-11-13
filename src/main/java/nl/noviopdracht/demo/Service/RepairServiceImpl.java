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

    @Autowired
    public RepairServiceImpl(RepairRepository repos, CarRepository carRepository, RepairRepository repairRepository) {
        this.repos = repos;
        this.carRepository = carRepository;
    }

    @Override
    public long saveRepair(RepairDTO repairDTO, CarDTO carDTO) {
        Repair repair = new Repair(carRepository.getById(carDTO.getCarID()),repairDTO.isRepairComfirm(),repairDTO.isPaymentComfirm(),repairDTO.getNotes(),repairDTO.getUseditems());
        repos.save(repair);

        return (long) repair.getRepID();
    }

}
