package nl.noviopdracht.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping("/paymentpage")
    public String showPaymentPage(Model model) {
        String testtekst = "dit is een test";
        model.addAttribute("tekst", testtekst);
        //model.addAttribute("prijsEXL",PrijsEXL);
        //model.addAttribute("prijsINCL",PrijsINCL);




        return "payment_page";
    }
}
