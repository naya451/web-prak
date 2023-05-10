package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.BuyersDAO;
import ru.msu.cmc.webprak.DAO.DeliveriesDAO;
import ru.msu.cmc.webprak.DAO.implementation.BuyersDAO_Implementation;
import ru.msu.cmc.webprak.DAO.implementation.DeliveriesDAO_Implementation;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

@Controller
public class BuyerController {

    @Autowired
    private final BuyersDAO buyersDAO = new BuyersDAO_Implementation();

    @Autowired
    private final DeliveriesDAO deliveriesDAO = new DeliveriesDAO_Implementation();

    @GetMapping("/buyers")
    public String peopleListPage(Model model) {
        List<Buyers> buyers = (List<Buyers>) buyersDAO.getAll();
        model.addAttribute("buyers", buyers);
        model.addAttribute("buyerService", buyersDAO);
        return "buyers";
    }

    @GetMapping("/buyer")
    public String buyerPage(@RequestParam(name = "buyerId") Long buyerId, Model model) {
        Buyers buyer = buyersDAO.getById(buyerId);

        if (buyer == null) {
            model.addAttribute("error_msg", "В базе нет заказчика с ID = " + buyerId);
            return "errorPage";
        }

        model.addAttribute("buyer", buyer);
        model.addAttribute("buyerService", buyersDAO);
        model.addAttribute("deliveriesService", deliveriesDAO);
        return "buyer";
    }

    @GetMapping("/editBuyer")
    public String editBuyerPage(@RequestParam(name = "buyerId", required = false) Long buyerId, Model model) {
        if (buyerId == null) {
            model.addAttribute("buyer", new Buyers());
            model.addAttribute("buyerService", buyersDAO);
            return "editBuyer";
        }

        Buyers buyer = buyersDAO.getById(buyerId);

        if (buyer == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + buyerId);
            return "errorPage";
        }

        model.addAttribute("buyer", buyer);
        model.addAttribute("buyerService", buyersDAO);
        return "editBuyer";
    }

    @PostMapping("/saveBuyer")
    public String saveBuyerPage(@RequestParam(name = "buyerId") Long buyerId,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "phone", required = false) String phone,
                                @RequestParam(name = "email", required = false) String email,
                                @RequestParam(name = "address", required = false) String address,
                                @RequestParam(name = "info", required = false) String info,
                                Model model) {
        Buyers buyer = buyersDAO.getById(buyerId);
        boolean changeIsSuccessful = false;

        if (buyer != null) {
            buyer.setName(name);
        } else {
            buyer = new Buyers(buyerId, name, phone, email, address, info);
        }

        model.addAttribute("error_msg", "Данные не сохранены");
        return "errorPage";
    }

    @PostMapping("/removeBuyer")
    public String removeBuyerPage(@RequestParam(name = "buyerId") Long buyerId) {
        buyersDAO.deleteById(buyerId);
        return "redirect:/buyers";
    }
}