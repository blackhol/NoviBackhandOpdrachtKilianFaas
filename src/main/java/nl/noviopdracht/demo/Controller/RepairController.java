package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.*;
import nl.noviopdracht.demo.Model.Part;
import nl.noviopdracht.demo.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class RepairController {

    private final RepairService rService;
    private final PartService pservice;
    private final CarService carService;
    private final OrderItemService orderItemService;
    private final ActionService actionService;


    public RepairController(RepairService rService, PartService pservice, CarService carService, OrderItemService orderItemService, ActionService actionService) {
        this.rService = rService;
        this.pservice = pservice;
        this.carService = carService;
        this.orderItemService = orderItemService;
        this.actionService = actionService;
    }

    @GetMapping("/repair")
    public String showRepairPage(Model model){

        RepairDTO repairDTO = new RepairDTO();
        OrderItemDTO orderItemDTO = new OrderItemDTO();



        model.addAttribute("repair" , repairDTO);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);
        model.addAttribute("actions",actionService.getAllActions());


        return "repair_page";
    }

    @PostMapping("/createRepair")
    public String createRepair(Model model, @ModelAttribute("repair") RepairDTO repairDTO, CarDTO carDTO,Part part,OrderItemDTO orderItemDTO){
        System.out.println(repairDTO);

        long repId = rService.saveRepair(repairDTO, carDTO);
        repairDTO.setRepID(repId);

        System.out.println("repair id ="+ repairDTO.getRepID());

        model.addAttribute("repairId",repId);

        model.addAttribute("repair" , repairDTO);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);
        model.addAttribute("actions",actionService.getAllActions());



        return "working_repair_form";
    }

    @PostMapping("/add_part_to_repair/{repairId}")
    public String addPartsToRepair(Model model, @PathVariable long repairId, @ModelAttribute("repair") RepairDTO repairDTO, Part part, OrderItemDTO orderItemDTO){
        PartDTO partDTO = new PartDTO();
        ActionDTO actionDTO = new ActionDTO();

        ArrayList<ActionDTO> actionDTOArrayList = actionService.getAllActions();
        ArrayList<PartDTO> partArrayList = pservice.getAllParts();

        model.addAttribute("repair" , repairDTO);
        model.addAttribute("parts", pservice.getAllParts());
        model.addAttribute("listofcars",carService.getAllCars());
        model.addAttribute("Partinuse",orderItemDTO);
        model.addAttribute("actions",actionService.getAllActions());

        orderItemDTO.setRepairID(repairId);

        orderItemDTO.setPrice(partArrayList.get((int) orderItemDTO.getPartId()).getPrice());
        orderItemDTO.setPrice(actionDTOArrayList.get((int) orderItemDTO.getActionId()).getPrice());

        orderItemService.saveOrderItem(repairDTO, partDTO,orderItemDTO,actionDTO);

        //reset for next part/action
        orderItemDTO.setActionId(0);
        orderItemDTO.setPartId(0);

        return"working_repair_form";
    }


}
