package nl.noviopdracht.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping("/paymentpage")
    public String showPaymentPage(Model model) {





        return "payment_page";
    }
}
