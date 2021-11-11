package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.PartService;
import nl.noviopdracht.demo.Service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

        OrderItem orderItem = new OrderItem();
        RepairDTO repairDTO = new RepairDTO();

        model.addAttribute("repair" , repairDTO);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("usingpart",orderItem);

        return "repair_page";
    }

    @PostMapping("/createRepair")
    public String createRepair(Model model, @ModelAttribute("repair") RepairDTO repairDTO, CarDTO carDTO){
        System.out.println(repairDTO);

        OrderItem orderItem = new OrderItem();

        long repId = rService.saveRepair(repairDTO, carDTO);
        repairDTO.setRepID(repId);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("usingpart",orderItem);

        return "working_repair_form";
    }

    @PostMapping("/add_part_to_repair")
    public String addPartsToRepair(Model model, @ModelAttribute("repair") RepairDTO repairDTO, PartDTO partDTO,@ModelAttribute("usingpart") OrderItem orderItem){
        rService.saveOrderItem(repairDTO, partDTO);

        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("usingpart",orderItem);


        return"working_repair_form";
    }


}
