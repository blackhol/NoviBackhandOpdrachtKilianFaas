package nl.noviopdracht.demo.Service;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Captor
    ArgumentCaptor<Car> carCaptor;

    @Test
    void getAllCarsTest() {
        //Arrange
        nl.noviopdracht.demo.Model.User user = new nl.noviopdracht.demo.Model.User();
        user.setId(1L);

        List<Car> testCars = new ArrayList<Car>();
        Car car1 = new Car();
        car1.setCarID(1);
        car1.setCarBrand("test1");
        car1.setOwnerID(1L);
        car1.setOwner(user);

        Car car2 = new Car();
        car2.setCarID(2);
        car2.setCarBrand("test2");
        car2.setOwnerID(2L);
        car2.setOwner(user);

        Car car3 = new Car();
        car3.setCarID(3);
        car3.setCarBrand("test3");
        car3.setOwnerID(3L);
        car3.setOwner(user);

        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);

        //Act
        when(carRepository.findAll()).thenReturn(testCars);

        carService.getAllCars();
        //Asserts
        assertThat(testCars.get(0)).isEqualTo(car1);
        assertThat(testCars.get(1)).isEqualTo(car2);
        assertThat(testCars.get(2)).isEqualTo(car3);

    }

    @Test
    void saveCarTest() {
        //Arrange
        Car car = new Car();
        car.setCarBrand("test");
        car.setCarID(1);
        carRepository.save(car);
        //Act
        verify(carRepository, times(1)).save(carCaptor.capture());
        var car1 = carCaptor.getValue();
        //Assert
        assertThat(car1.getCarID()).isEqualTo(1);
        assertThat(car1.getCarBrand()).isEqualTo("test");
    }

    @Test
    void findByIdTest() {
        //Arrange
        nl.noviopdracht.demo.Model.User user = new nl.noviopdracht.demo.Model.User();
        user.setId(1L);

        List<Car> testCars = new ArrayList<Car>();
        Car car1 = new Car();
        car1.setCarID(1);
        car1.setCarBrand("test1");
        car1.setOwnerID(1L);
        car1.setOwner(user);

        testCars.add(car1);


        //Act
        when(carRepository.findById(1L)).thenReturn(Optional.of(car1));

        carService.findById(1L);
        //Asserts
        assertThat(testCars.get(0).getCarID()).isEqualTo(1L);
    }

}