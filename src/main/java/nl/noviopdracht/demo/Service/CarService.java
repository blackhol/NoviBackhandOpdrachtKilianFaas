package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.files.Carfiles;

import java.util.ArrayList;
import java.util.List;

public interface CarService {

    public void saveCar(CarDTO carDTO, UserDTO userDTO);

     Car save(Car car);

    public ArrayList<CarDTO> getAllCars();

    Car findById(Long carID);


    List<Carfiles> findFilesByUserId(Long carID);

    Car updateCar(Car car);
}
