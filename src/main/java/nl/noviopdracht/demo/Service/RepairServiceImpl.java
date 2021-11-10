package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.PartRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repos;
    private final CarRepository carRepository;

    @Autowired
    public RepairServiceImpl(RepairRepository repos,CarRepository carRepository) {
        this.repos = repos;
        this.carRepository = carRepository;
    }

    @Override
    public void saveRepair(RepairDTO repairDTO, CarDTO carDTO) {
        Repair repair = new Repair(carRepository.getById(carDTO.getCarID()),repairDTO.isRepairComfirm(),repairDTO.isPaymentComfirm(),repairDTO.getNotes(),repairDTO.getUseditems());
        repos.save(repair);

    }
}
