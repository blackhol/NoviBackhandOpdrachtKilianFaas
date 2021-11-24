package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.files.Carfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringFileUploadController {

    @Autowired private CarService carService;

    @GetMapping(value = "/")
    public String car(Model model){
        ArrayList<CarDTO> cars = carService.getAllCars();
        model.addAttribute("cars",cars);
        model.addAttribute("car", new Car());
        model.addAttribute("carfiles",new ArrayList<Carfiles>());
        model.addAttribute("isAdd", true);




        return "/add_car_paper";
    }

}
