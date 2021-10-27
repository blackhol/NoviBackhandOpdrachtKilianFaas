package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class CarController {

    private final CarService cService;
    private final UserService uservice;


    public CarController(CarService cService , UserService uService){

        this.cService = cService;
        this.uservice = uService;
    }


    @GetMapping("/add_car")
    public String showCarForm(Model model){
        CarDTO carDTO = new CarDTO();
        model.addAttribute("car", carDTO);
        model.addAttribute("User", uservice.gettAllUsers());


        return "car_form";
    }
    @PostMapping("/add_car")
    public String showAddedCarForm(@Valid @ModelAttribute("car") CarDTO carDTO, BindingResult bindingResult){
        System.out.println(carDTO);
        if(bindingResult.hasErrors()){

            return "car_form";
        }
        else{
            cService.saveCar(carDTO);
            return "car_form_succes";
        }

    }
}
