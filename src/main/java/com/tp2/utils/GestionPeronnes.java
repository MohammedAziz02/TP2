package com.tp2.utils;

import com.tp2.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class GestionPeronnes {

  /*  @Autowired
    CalculAgeImpl calculAge;*/

    // cette méthode permet d'ajouter un person dans un hashSet qui existe déja dans la session
    // si il existe déja un person du meme id donc il suffit de ,le modifier
    // si le hesh set est empty on va ajouter
    //  on verifie l'existance si oui modifier sinon ajouter
    public static void addorUpdatePerson(HashSet<Person> personnes, Person p){
        if (!personnes.isEmpty()) {
            for (Person person : personnes) {
                if (p.getId() == person.getId()) {
                    System.out.println("dans la boucle deja existe ID");
                    person.setFirstName(p.getFirstName());
                    person.setLastName(p.getLastName());
                    person.setCne(p.getCne());
                    person.setDate_naiss(p.getDate_naiss());
                   /* person.setAge(calculAge.calculer(p.getDate_naiss()));*/
                } else {
                    System.out.println("dans la boucle deja n'existe Pas ID");
                  /*  p.setAge(calculAge.calculer(p.getDate_naiss()));*/
                    personnes.add(p);
                }
            }
        }else{
            System.out.println("l'ajout d'un person");
         /*   p.setAge(calculAge.calculer(p.getDate_naiss()));*/
            personnes.add(p);
        }
    }
}
