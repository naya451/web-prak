package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.BuyersDAO;
import ru.msu.cmc.webprak.DAO.implementation.BuyersDAO_Implementation;
import ru.msu.cmc.webprak.models.Buyers;

@Controller
public class BuyerController {

    @Autowired
    private final BuyersDAO buyersDAO = new BuyersDAO_Implementation();

   /* @GetMapping("/buyers")
    public String peopleListPage(Model model) {
        List<Buyers> people = (List<Buyers>) buyersDAO.getAll();
        model.addAttribute("people", people);
        model.addAttribute("buyerService", buyersDAO);
        return "buyers";
    }*/

    @GetMapping("/buyer")
    public String buyerPage(@RequestParam(name = "buyerId") Long buyerId, Model model) {
        Buyers buyer = buyersDAO.getById(buyerId);

        if (buyer == null) {
            model.addAttribute("error_msg", "В базе нет заказчика с ID = " + buyerId);
            return "errorPage";
        }

        model.addAttribute("buyer", buyer);
        model.addAttribute("buyerService", buyersDAO);
        return "buyer";
    }

    /*@GetMapping("/editBuyer")
    public String editBuyerPage(@RequestParam(name = "buyerId", required = false) Long buyerId, Model model) {
        if (buyerId == null) {
            model.addAttribute("buyer", new Buyer());
            model.addAttribute("buyerService", buyerDAO);
            model.addAttribute("placeService", placeDAO);
            return "editBuyer";
        }

        Buyer buyer = buyerDAO.getById(buyerId);

        if (buyer == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + buyerId);
            return "errorPage";
        }

        model.addAttribute("buyer", buyer);
        model.addAttribute("buyerService", buyerDAO);
        model.addAttribute("placeService", placeDAO);
        return "editBuyer";
    }*/

    /*@PostMapping("/saveBuyer")
    public String saveBuyerPage(@RequestParam(name = "buyerId") Long buyerId,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "gender") String gender,
                                 @RequestParam(name = "birthDate", required = false) Long birthDate,
                                 @RequestParam(name = "deathDate", required = false) Long deathDate,
                                 @RequestParam(name = "info", required = false) String info,
                                 Model model) {
        Buyer buyer = buyerDAO.getById(buyerId);
        boolean changeIsSuccessful = false;

        if (buyer != null) {
            buyer.setName(name);
            buyer.setGender(gender);
            buyer.setBirth(birthDate);
            buyer.setDeath(deathDate);
            buyer.setCharacter(info);
        } else {
            buyer = new Buyer(buyerId, name, gender, birthDate, deathDate, info);
        }

        model.addAttribute("error_msg", "Данные не сохранены");
        return "errorPage";
    }

    @PostMapping("/removeBuyer")
    public String removeBuyerPage(@RequestParam(name = "buyerId") Long buyerId) {
        buyerDAO.deleteById(buyerId);
        return "redirect:/buyers";
    }*/
}