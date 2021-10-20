package nl.noviopdracht.demo.Controller;

import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.Service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddPartController {

    private final PartService pService;

    public AddPartController(PartService pService) {

        this.pService = pService;
    }

    @GetMapping("/add_part")
    public String showpartForm(Model model) {
        PartDTO partDTO = new PartDTO();
        model.addAttribute("part", partDTO);


        return "addpart_form";
    }
    @PostMapping("/add_part")
    public String showpartForm(@Valid @ModelAttribute("part") PartDTO partDTO, BindingResult bindingResult){
        System.out.println(partDTO);
        if(bindingResult.hasErrors()){

            return "addpart_form";
        }
        else{
            pService.savePart(partDTO);
            return "addpart_succes";
        }

    }


}