package com.tp2.web.Controllers;

import com.tp2.Models.Person;
import com.tp2.utils.tpClasses.CalculAgeImpl;
import com.tp2.utils.GestionPeronnes;
import com.tp2.utils.tpClasses.CalculAgeMoisImpl;
import com.tp2.utils.tpClasses.CompareAgeImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    HttpSession session;
    private CalculAgeImpl calculAge;

    @Autowired
    public MyController(CalculAgeImpl calculAge) {
        this.calculAge = calculAge;
    }

    @Autowired
    private CompareAgeImpl compareAge;

    private CalculAgeMoisImpl calculAgeMois;

    @Autowired
    public void setCalculeAgeMois(CalculAgeMoisImpl calculeAgeMois) {
        this.calculAgeMois = calculeAgeMois;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        // instanciation d'un person pour qu'il soit bindi automatiquement lorsque on se redirige vers la formualaire
        // les champs qui ont comme attribut path seront automatiquemnt rempliss
        System.out.println("calculaagemois " + calculAgeMois);
        Person person = new Person();
        model.addAttribute("person", person);
        // l'inistialisation de la session ici si elle n'existe pas
        if (session.getAttribute("personnes") == null) {
            System.out.println("création de la session");
            session.setAttribute("personnes", new ArrayList<>());
        }
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("person") Person p) {
        ArrayList<Person> personnes = (ArrayList<Person>) session.getAttribute("personnes");
        /*System.out.println("test");
        System.out.println(" from test "+ p);*/
        if (personnes != null) {
            GestionPeronnes.addorUpdatePerson(personnes, p);
        }
        return "form";
    }

    @GetMapping("/showPersonnes")
    public String showPersonnes(Model model) {
        ArrayList<Person> personnes = (ArrayList<Person>) session.getAttribute("personnes");
        // par age -- ==> ++
       /*    Collections.sort(personnes, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return compareAge.comparer(p1.getDate_naiss(), p2.getDate_naiss());
            }
        });
        */


        // par nombre de mois du ++ ===> --
     /*   ArrayList<Person> personnes = (ArrayList<Person>) session.getAttribute("personnes");*/
        Collections.sort(personnes, new Comparator<Person>() {
                    public int compare(Person p1, Person p2) {
                        int age1 = calculAgeMois.calculer(p1.getDate_naiss());
                        int age2 = calculAgeMois.calculer(p2.getDate_naiss());
                        return Integer.compare(age2, age1);
                    }
                });

                // Ajout de la liste des étudiants au modèle pour affichage dans une table HTML
                /* model.addAttribute("students", personnes);*/
                model.addAttribute("calculate", calculAgeMois);

        return "listespersonnes";


    }
}

