package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.Model.Car;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import nl.noviopdracht.demo.Service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
public class CarController {

    private final CarService cService;

    public CarController(CarService cService){

        this.cService = cService;
    }

    @GetMapping("/add_car")
    public String showCarForm(Model model){
        CarDTO carDTO = new CarDTO();
        model.addAttribute("car", carDTO);
        List<String> listOfCustomers = Arrays.asList("pietje","keesje","jantje");
        model.addAttribute("listOfCustomers", listOfCustomers);



        return "car_form";
    }
}
