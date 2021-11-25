package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;

import java.util.ArrayList;

public interface CarService {

    public void saveCar(CarDTO carDTO, UserDTO userDTO);

     Car save(Car car);

    public ArrayList<CarDTO> getAllCars();


}
