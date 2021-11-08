package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Service.PartService;
import nl.noviopdracht.demo.Service.RepairService;
import nl.noviopdracht.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RepairController {

    private final RepairService rService;
    private final PartService pservice;


    public RepairController(RepairService rService, PartService pservice) {
        this.rService = rService;
        this.pservice = pservice;
    }

    @GetMapping("/repair")
    public String showRepairPage(Model model){
        RepairDTO repairDTO = new RepairDTO();
        model.addAttribute("repair" , repairDTO);
        model.addAttribute("part", pservice.getAllParts());



        return "repair_page";
    }
    @PostMapping("/createRepair")
    public String createRepair(@ModelAttribute("repair") RepairDTO repairDTO){
        System.out.println(repairDTO);
        rService.saveRepair(repairDTO);

        return "repair_page";
    }


}
