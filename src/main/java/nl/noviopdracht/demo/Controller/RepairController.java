package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RepairController {

    private final RepairService rService;

    public RepairController(RepairService rService) {
        this.rService = rService;
    }

    @GetMapping("/repair")
    public String showRepairPage(Model model){
        RepairDTO repairDTO = new RepairDTO();
        model.addAttribute("repair" , repairDTO);
        List<String> carParts = Arrays.asList();
        

    return "repair_page";
    }
    @PostMapping("/createRepair")
    public String createRepair(@ModelAttribute("repair") RepairDTO repairDTO){
        System.out.println(repairDTO);
        rService.saveRepair(repairDTO);

        return "repair_page";
    }


}
