package com.tp2.web.Controllers;

import com.tp2.Models.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("exo1")
public class ControllerDoSameThingAsServletEx1TP1 {
    @Autowired
    HttpSession session;

    @GetMapping("createPerson")
    public String createPersonInSession(HttpServletRequest request, @RequestParam("nom") int id, @RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("datenaiss") Date date_naiss, @RequestParam("cne") String cne) {
        System.out.println("from createPerson method  nom : " + nom);
        System.out.println("from createPerson method  prenom : " + prenom);
        System.out.println("from createPerson method  date de naissance : " + date_naiss);
        System.out.println("from createPerson method  cne : " + cne);

       /* HttpSession session = request.getSession();*/
        session.setAttribute("p1", new Person(id,nom, prenom, date_naiss, cne));

        return "test";
    }
    @GetMapping("private")
    public String gotoprivatethings(HttpServletRequest request) {
        return "private";
    }

}
