package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Repository.RepairRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RepairServiceImplTest {
    @Mock
    RepairRepository repairRepository;

    @InjectMocks
    private RepairServiceImpl repairService;

    @Captor
    ArgumentCaptor<Repair> repairCaptor;

    @Test
    void saveRepairTest() {
        //arrange
        Repair repair = new Repair();
        repair.setRepID(5);
        repair.setRepairComfirm(true);
        repairRepository.save(repair);
        //Act
        verify(repairRepository, times(1)).save(repairCaptor.capture());
        var repair1 = repairCaptor.getValue();
        //Assert
        assertThat(repair1.getRepID()).isEqualTo(5);
        assertThat(repair1.isRepairComfirm()).isTrue();
    }

    @Test
    void getAllRepairsTest() {
        //Arrange
        Car car = new Car();
        car.setCarID(1);
        car.setCarBrand("test");
        car.setOwnerID(5L);

        List<Repair> repairList = new ArrayList<>();

        Repair repair1 = new Repair();
        repair1.setRepID(1);
        repair1.setRepairComfirm(false);
        repair1.setCar(car);

        Repair repair2 = new Repair();
        repair2.setRepID(2);
        repair2.setRepairComfirm(false);
        repair2.setCar(car);


        Repair repair3 = new Repair();
        repair3.setRepID(3);
        repair3.setRepairComfirm(false);
        repair3.setCar(car);


        repairList.add(repair1);
        repairList.add(repair2);
        repairList.add(repair3);
        //Act
        when(repairRepository.findAll()).thenReturn(repairList);

        repairService.getAllRepairs();
        //Assert
        assertThat(repairList.get(0)).isEqualTo(repair1);
        assertThat(repairList.get(1)).isEqualTo(repair2);
        assertThat(repairList.get(2)).isEqualTo(repair3);

    }
//    @Test
//    void updateAgreeRepairBooleanTest(){
//        //Arrange
//        Car car = new Car();
//        car.setCarID(1);
//        car.setCarBrand("test");
//        car.setOwnerID(5L);
//
//        Repair repair = new Repair();
//        repair.setRepID(1);
//        repair.setRepairComfirm(false);
//        repair.setCar(car);
//        //Act
//        verify(repairRepository, times(1)).save(repairCaptor.capture());
//        when(repairService.updateAgreeRepairBoolean(true, 1)).thenReturn(repair);
//        var repair1 = repairCaptor.getValue();
//        //Assert
//        assertThat(repair1.isRepairComfirm()).isTrue();
//
//    }
}