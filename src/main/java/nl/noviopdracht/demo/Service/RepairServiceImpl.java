package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Repair repair = new Repair(carRepository.getById(carDTO.getCarID()),repairDTO.isRepairComfirm(),repairDTO.isPaymentComfirm());
        repos.save(repair);

        return (long) repair.getRepID();
    }

    @Override
    public ArrayList<RepairDTO> getAllRepairs() {
        List<Repair> repairList = repos.findAll();
        ArrayList<RepairDTO> repairDTOList = new ArrayList<RepairDTO>();

        for
        (
                Repair repair:repairList
        )
        {
            RepairDTO repairconver = new RepairDTO();
            repairconver.setRepID((long) repair.getRepID());
            repairconver.setCarID(repair.getCar().getCarID());
            repairconver.setRepairComfirm(repair.isRepairComfirm());
            repairconver.setPaymentComfirm(repair.isPaymentComfirm());
            repairDTOList.add(repairconver);
        }
        return repairDTOList;
    }

    @Override
    public void updateAgreeRepairBoolean(boolean agree, long repairID) {
        Repair repair = repos.findById(repairID);
        repair.setAgree_on_repiar(agree);
        repos.save(repair);
    }


}
