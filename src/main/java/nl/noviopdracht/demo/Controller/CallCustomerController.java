package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.CallCaseDTO;
import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.CallCase;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.RepairService;
import nl.noviopdracht.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CallCustomerController {

    private final CarService carService;
    private final UserService userService;
    private final RepairService repairService;


    public CallCustomerController(CarService carService, UserService userService, RepairService repairService) {
        this.carService = carService;
        this.userService = userService;
        this.repairService = repairService;
    }

    @GetMapping("/callcustomer")
    public String callcustomer(Model model){
        ArrayList<RepairDTO> allrepairs = repairService.getAllRepairs();
        ArrayList<CarDTO> allcars = carService.getAllCars();
        ArrayList<UserDTO> allusers = userService.gettAllUsers();

        Boolean agree = false;

        System.out.println(allcars.size());
        System.out.println(allusers.size());
        System.out.println(allrepairs.size());

        model.addAttribute("agree", agree);

        ArrayList<CallCaseDTO> repairstocall = new ArrayList<>();

        for (RepairDTO repairDTO:allrepairs
             )
        {
            CallCaseDTO callCaseDTO = new CallCaseDTO();
            if(repairDTO.isAgree_on_repiar()==false){
             callCaseDTO.setCarid((long) repairDTO.getCarID());

             callCaseDTO.setOwnerid(allcars.get((int) callCaseDTO.getCarid()).getOwnerID());

             callCaseDTO.setUsername(allusers.get((int) callCaseDTO.getOwnerid()).getName());
             callCaseDTO.setCellnumber(allusers.get((int) callCaseDTO.getOwnerid()).getCellnumber());
             repairstocall.add(callCaseDTO);
         }
        }
        model.addAttribute("calllist",repairstocall);

        return "callcustomerpage";
    }
    @PostMapping("/setagree")
    public String setagree(){
        System.out.println("dit is een test");
        return "callcustomerpage";
    }
}
