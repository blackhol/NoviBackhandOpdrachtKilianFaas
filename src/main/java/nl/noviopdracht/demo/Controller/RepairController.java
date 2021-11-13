package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.OrderItemDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.OrderItem;
import nl.noviopdracht.demo.Model.Part;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.OrderItemService;
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
    private final OrderItemService orderItemService;


    public RepairController(RepairService rService, PartService pservice, CarService carService, OrderItemService orderItemService) {
        this.rService = rService;
        this.pservice = pservice;
        this.carService = carService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/repair")
    public String showRepairPage(Model model){

//        OrderItem orderItem = new OrderItem();
        RepairDTO repairDTO = new RepairDTO();
//        Part part = new Part();
        OrderItemDTO orderItemDTO = new OrderItemDTO();



        model.addAttribute("repair" , repairDTO);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);

        return "repair_page";
    }

    @PostMapping("/createRepair")
    public String createRepair(Model model, @ModelAttribute("repair") RepairDTO repairDTO, CarDTO carDTO,Part part,OrderItemDTO orderItemDTO){
        System.out.println(repairDTO);

//        OrderItem orderItem = new OrderItem();

        long repId = rService.saveRepair(repairDTO, carDTO);
        repairDTO.setRepID(repId);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);

        return "working_repair_form";
    }

    @PostMapping("/add_part_to_repair")
    public String addPartsToRepair(Model model, @ModelAttribute("repair") RepairDTO repairDTO,Part part,OrderItemDTO orderItemDTO){
        PartDTO partDTO = new PartDTO();
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);

        System.out.println(" PART ID = "+orderItemDTO.getPartId());
        //PartDTO partDTO = new PartDTO(part.getId(), part.getPartname(),part.getPrice());
        orderItemService.saveOrderItem(repairDTO, partDTO,orderItemDTO);

        return"working_repair_form";
    }


}
