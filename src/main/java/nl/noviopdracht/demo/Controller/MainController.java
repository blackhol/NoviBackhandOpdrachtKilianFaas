package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Service.PartService;
import nl.noviopdracht.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final UserService uService;

    public MainController( UserService uService){
        this.uService = uService;
    }


    @GetMapping("/register")
    public String showForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        List<String> listProfession = Arrays.asList("Customer","Mechanic", "BackOfficeWorker", "AdmAssistant", "cashier");
        model.addAttribute("listProfession", listProfession);

        return "register_form";


    }
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {
        System.out.println(userDTO);
        if(bindingResult.hasErrors()){

            List<String> listProfession = Arrays.asList("Customer","Mechanic", "BackOfficeWorker", "AdmAssistant", "cashier");
            model.addAttribute("listProfession", listProfession);

            return "register_form";
        }
        if(userDTO.getProfession() == "Customer") {
            uService.saveUser(userDTO);
            return "register_success";
        }
        else{
            uService.saveUser(userDTO);
            return "register_success";
        }
    }



}