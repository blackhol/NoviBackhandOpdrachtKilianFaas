package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Model.User;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.UserService;
import nl.noviopdracht.demo.files.Carfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringFileUploadController {

    @Autowired private CarService carService;
    @Autowired private UserService userService;

    @GetMapping(value = "/carpaper")
    public String car(Model model){
        ArrayList<CarDTO> cars = carService.getAllCars();
        ArrayList<UserDTO> users = userService.gettAllUsers();
        model.addAttribute("cars",cars);
        model.addAttribute("car", new Car());
        model.addAttribute("carfiles",new ArrayList<Carfiles>());
        model.addAttribute("isAdd", true);
        model.addAttribute("users", users);

        return "/add_car_paper";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute Car car, RedirectAttributes redirectAttributes, Model model){
        Car dbCar = carService.save(car);
        if(dbCar != null){
            redirectAttributes.addFlashAttribute("successmessage", "Car is saved succesfully");
            return "redirecht:/";
        }
        else {
            model.addAttribute("errormessage","car is not saved, please try again");
            model.addAttribute("car",car);
            return "view/car";
        }
    }


}
