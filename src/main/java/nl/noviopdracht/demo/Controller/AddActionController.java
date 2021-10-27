package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.ActionDTO;
import nl.noviopdracht.demo.Service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddActionController {

    private final ActionService aService;

    public AddActionController(ActionService aService) {

        this.aService = aService;
    }

    @GetMapping("/add_service")
    public String showserviceForm(Model model) {
        ActionDTO actionDTO = new ActionDTO();
        model.addAttribute("part", actionDTO);


        return "addservice_form";
    }
    @PostMapping("/add_service")
    public String showserviceForm(@Valid @ModelAttribute("part") ActionDTO actionDTO, BindingResult bindingResult){
        System.out.println(actionDTO);
        if(bindingResult.hasErrors()){

            return "addservice_form";
        }
        else{
            aService.saveAction(actionDTO);
            return "addservice_succes";
        }

    }


}