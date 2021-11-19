package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.OrderItemDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Service.OrderItemService;
import nl.noviopdracht.demo.Service.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PaymentController {
    private final RepairService repairService;
    private final OrderItemService orderItemService;

    public PaymentController(RepairService repairService, OrderItemService orderItemService) {
        this.repairService = repairService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/paymentpage")
    public String showPaymentPage(Model model, Long repairID) {
        RepairDTO repairDTO = new RepairDTO();


        model.addAttribute("repairList", repairService.getAllRepairs());
        model.addAttribute("selectedRepair", repairDTO);


        return "payment_page";
    }

    @GetMapping("/pay_repair")
    public String showselectedpaymentpage(Model model, @RequestParam("repID") String repairID) {
        long repairId = Long.parseLong(repairID);
        Repair repair = new Repair();
        System.out.println("id:" + repairId);
        ArrayList<OrderItemDTO> allOrderItems = orderItemService.GetAllOrderItem();
        ArrayList<OrderItemDTO> repairIdOrderItems = new ArrayList<>();
        Double PriceINCL = new Double(0);
        Float PriceEXCL = new Float(0);

        for (
                OrderItemDTO orderitem : allOrderItems
            )
        {
//            Long checkrepid = orderitem.getRepairID();
            Long checkrepid = repairId;

            System.out.println(checkrepid);
//            if (checkrepid == orderitem.getRepairID()){
//                repairIdOrderItems.add(orderitem);
//            }
            if (checkrepid.equals(orderitem.getRepairID())){
                repairIdOrderItems.add(orderitem);
                PriceEXCL += orderitem.getPrice();
            }
            model.addAttribute("alluseditems",repairIdOrderItems);
            model.addAttribute("payingrepair", repair);
            model.addAttribute("priceEXCL",PriceEXCL);
            PriceINCL = PriceEXCL * 1.21;
            model.addAttribute("priceINCL",PriceINCL);


        }

        return "selected_payment_page";
    }
    @PostMapping("/payment_succes")
    public String Customerhaspayed(){

        return "payment_complete";
    }

}

