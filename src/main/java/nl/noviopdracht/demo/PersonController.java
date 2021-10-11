package nl.noviopdracht.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    PersonRepository repos;

    @GetMapping("/persons/add")
    public String voegToe(Model model) {
        PersonDTO personDTO = new PersonDTO();
        model.addAttribute("person", personDTO);
        System.out.println("Hellow World");
        return "CustomerForm";
    }

    @PostMapping("/persons/add")
    public String addPerson(@Valid @ModelAttribute("person") PersonDTO personDTO, BindingResult result) {
        Person p = new Person();
        p.setName(personDTO.getName());
        repos.save(p);
        return "CustomerForm";
    }

}
