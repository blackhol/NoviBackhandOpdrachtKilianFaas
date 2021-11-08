package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.PartRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repos;

    public RepairServiceImpl(RepairRepository repos) {
        this.repos = repos;
    }

    @Override
    public void saveRepair(RepairDTO repairDTO) {
        Repair repair = new Repair(repairDTO.getCarID(), repairDTO.isRepairComfirm() , repairDTO.getNotes(), repairDTO.isRepairComfirm());
        repos.save(repair);

    }
}
