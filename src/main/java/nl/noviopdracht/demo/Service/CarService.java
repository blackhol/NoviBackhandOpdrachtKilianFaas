package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;

import java.util.ArrayList;

public interface CarService {

    public void saveCar(CarDTO carDTO, UserDTO userDTO);

    public ArrayList<CarDTO> getAllCars();


}
