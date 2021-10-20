package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
    public class CarServiceImpl implements CarService {
    private final CarRepository repos;

    public CarServiceImpl(CarRepository repos) {
        this.repos = repos;
    }


    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getOwnerID(),carDTO.getCarBrand(), carDTO.getLicencePlate(), carDTO.getNotes());
        repos.save(car);
    }

}
