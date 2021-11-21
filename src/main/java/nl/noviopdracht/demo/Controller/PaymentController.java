package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.ActionDTO;
import nl.noviopdracht.demo.DTO.OrderItemDTO;
import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.RepairDTO;
import nl.noviopdracht.demo.Model.RegisterItem;
import nl.noviopdracht.demo.Model.Repair;
import nl.noviopdracht.demo.Service.ActionService;
import nl.noviopdracht.demo.Service.OrderItemService;
import nl.noviopdracht.demo.Service.PartService;
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
    private final PartService partService;
    private final ActionService actionService;

    public PaymentController(RepairService repairService, OrderItemService orderItemService, PartService partService, ActionService actionService) {
        this.repairService = repairService;
        this.orderItemService = orderItemService;
        this.partService = partService;
        this.actionService = actionService;
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

        ArrayList<PartDTO> listofparts = partService.getAllParts();
        ArrayList<ActionDTO> listofactions = actionService.getAllActions();

        for (
                OrderItemDTO orderitem : allOrderItems
            )
        {
            Long checkrepid = repairId;

            System.out.println(checkrepid);

            if (checkrepid.equals(orderitem.getRepairID())){
                repairIdOrderItems.add(orderitem);
                PriceEXCL += orderitem.getPrice();
            }


            ArrayList<RegisterItem> registerlist = new ArrayList<>();
            for (
                    OrderItemDTO orderitemDTO:repairIdOrderItems
                 )
            {
                RegisterItem registerItemconver = new RegisterItem();
                if(orderitemDTO.getPartId() > 0){
                    registerItemconver.setName((listofparts.get((int) orderitem.getPartId()).getPartname()));
                    registerItemconver.setPrice((listofparts.get((int) orderitem.getPartId()).getPrice()));
                    registerlist.add(registerItemconver);

                }
                if(orderitemDTO.getActionId() > 0){
                    registerItemconver.setName(listofactions.get((int) orderitem.getActionId()).getName());
                    registerItemconver.setPrice(listofactions.get((int) orderitem.getActionId()).getPrice());
                    registerlist.add(registerItemconver);
                }


            }

            model.addAttribute("alluseditems",registerlist);
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

