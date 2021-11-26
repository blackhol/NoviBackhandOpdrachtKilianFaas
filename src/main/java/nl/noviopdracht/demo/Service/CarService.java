package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.files.Carfiles;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public interface CarService {

    public void saveCar(CarDTO carDTO, UserDTO userDTO);

     Car save(Car car);

    public ArrayList<CarDTO> getAllCars();

    Car findById(Long carID);


    List<Carfiles> findFilesByUserId(Long carID);

    Car updateCar(Car car);



}
