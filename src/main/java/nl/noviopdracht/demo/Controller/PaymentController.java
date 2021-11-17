package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
    private final RepairService repairService;

    public PaymentController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/paymentpage")
    public String showPaymentPage(Model model,Long repairID) {
        RepairDTO repairDTO = new RepairDTO();


        model.addAttribute("repairList" , repairService.getAllRepairs());
        model.addAttribute("selectedRepair" , repairDTO);







        return "payment_page";
    }

    @GetMapping("/pay_repair")
    public String showselectedpaymentpage(Model model, @PathVariable Long repairDTO){

        return "selected_payment_page";
    }
}
