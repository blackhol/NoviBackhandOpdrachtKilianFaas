package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
    public class CarServiceImpl implements CarService {
    private final CarRepository repos;
    private final UserRepository userRepository;

    public CarServiceImpl(CarRepository repos, UserRepository userRepository) {
        this.repos = repos;
        this.userRepository = userRepository;
    }


    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = new Car(userRepository.getById(carDTO.getOwnerID()),carDTO.getCarBrand(), carDTO.getLicencePlate());
        repos.save(car);
    }

}
