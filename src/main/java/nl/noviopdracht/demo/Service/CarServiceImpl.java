package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Repository.CarFileRepository;
import nl.noviopdracht.demo.Repository.CarRepository;
import nl.noviopdracht.demo.Repository.UserRepository;
import nl.noviopdracht.demo.files.Carfiles;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
    public class CarServiceImpl implements CarService {
    private final CarRepository repos;
    private final UserRepository userRepository;
    private final UploadPathService uploadPathService;
    private final CarFileRepository carFileRepository;

    @Autowired
    public CarServiceImpl(CarRepository repos, UserRepository userRepository, UploadPathService uploadPathService, CarFileRepository carFileRepository) {
        this.repos = repos;
        this.userRepository = userRepository;
        this.uploadPathService = uploadPathService;
        this.carFileRepository = carFileRepository;
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

    @Override
    public Car save(Car car) {
        Car dbCar = repos.save(car);
        if(dbCar != null && car.getFiles()!=null && car.getFiles().size()>0){
            for(MultipartFile file : car.getFiles()){
                String fileName = file.getOriginalFilename();
                String modifiedFileName = FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);
                File storeFile = uploadPathService.getFilePath(modifiedFileName, "images");
                if(storeFile != null){
                    try {
                        FileUtils.writeByteArrayToFile(storeFile, file.getBytes());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Carfiles files = new Carfiles();
                files.setFileExtension(FilenameUtils.getExtension(fileName));
                files.setFilename(fileName);
                files.setModifiedFileName(modifiedFileName);
                files.setCar(dbCar);
                carFileRepository.save(files);

            }
        }

        return dbCar;
    }
}