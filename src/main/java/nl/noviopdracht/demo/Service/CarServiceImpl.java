package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
    public class CarServiceImpl implements CarService {
    private final CarRepository repos;
    private final UserRepository userRepository;

    @Autowired
    public CarServiceImpl(CarRepository repos, UserRepository userRepository) {
        this.repos = repos;
        this.userRepository = userRepository;

    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> carsList = repos.findAll();
        ArrayList<CarDTO> carDTOList = new ArrayList<CarDTO>();

        for
        (
                Car car:carsList
        )
        {
            CarDTO carconver = new CarDTO();
            carconver.setCarID(car.getCarID());
            carconver.setCarBrand(car.getCarBrand());
            carconver.setLicencePlate(car.getLicencePlate());
            carconver.setOwnerID(car.getOwner().getId());
            carDTOList.add(carconver);
        }

        return carDTOList;
    }

    @Override
    public void saveCar(CarDTO carDTO, UserDTO userDTO) {
        Car car = new Car(userRepository.getById(carDTO.getOwnerID()),carDTO.getCarBrand(),carDTO.getLicencePlate());
        repos.save(car);
    }

}