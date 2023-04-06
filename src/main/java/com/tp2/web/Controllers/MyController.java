package com.tp2.web.Controllers;

import com.tp2.Models.Person;
import com.tp2.utils.CalculAgeImpl;
import com.tp2.utils.GestionPeronnes;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MyController {
    @Autowired
    HttpSession session;
    private CalculAgeImpl calculAge;
     @Autowired
    public MyController(CalculAgeImpl calculAge){
        this.calculAge=calculAge;
    }
  /*  @Autowired
    private  GestionPeronnes gestionPeronnes;*/
    @GetMapping("/form")
    public String showForm(Model model) {
        // instanciation d'un person pour qu'il soit bindi automatiquement lorsque on se redirige vers la formualaire
        // les champs qui ont comme attribut path seront automatiquemnt rempliss
        Person person = new Person();
        model.addAttribute("person", person);
        // l'inistialisation de la session ici si elle n'existe pas
        if (session.getAttribute("personnes") == null) {
            System.out.println("création de la session");
            session.setAttribute("personnes", new HashSet<Person>());
        }
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("person") Person p) {
        HashSet<Person> personnes = (HashSet<Person>) session.getAttribute("personnes");
        /*System.out.println("test");
        System.out.println(" from test "+ p);*/
        if (personnes != null) {
            GestionPeronnes.addorUpdatePerson(personnes,p);
        }
        return "form";
    }

    @GetMapping("/showPersonnes")
    public String showPersonnes(Model model) {
        model.addAttribute("calculate",calculAge);
        return "listespersonnes";
    }


}
