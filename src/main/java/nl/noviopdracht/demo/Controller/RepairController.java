package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.PartService;
import nl.noviopdracht.demo.Service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RepairController {

    private final RepairService rService;
    private final PartService pservice;
    private final CarService carService;


    public RepairController(RepairService rService, PartService pservice, CarService carService) {
        this.rService = rService;
        this.pservice = pservice;
        this.carService = carService;
    }

    @GetMapping("/repair")
    public String showRepairPage(Model model){

        RepairDTO repairDTO = new RepairDTO();

        model.addAttribute("repair" , repairDTO);
        //model.addAttribute("part", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());

        return "repair_page";
    }

    @PostMapping("/createRepair")
    public String createRepair(@ModelAttribute("repair") RepairDTO repairDTO, CarDTO carDTO){
        System.out.println(repairDTO);
        rService.saveRepair(repairDTO, carDTO);

        return "repair_page";
    }


}
