package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.SellersDAO;
import ru.msu.cmc.webprak.DAO.SuppliesDAO;
import ru.msu.cmc.webprak.DAO.implementation.SellersDAO_Implementation;
import ru.msu.cmc.webprak.DAO.implementation.SuppliesDAO_Implementation;
import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

@Controller
public class SellerController {

    @Autowired
    private final SellersDAO sellersDAO = new SellersDAO_Implementation();

    @Autowired
    private final SuppliesDAO suppliesDAO = new SuppliesDAO_Implementation();

    @GetMapping("/sellers")
    public String peopleListPage(Model model) {
        List<Sellers> sellers = (List<Sellers>) sellersDAO.getAll();
        model.addAttribute("sellers", sellers);
        model.addAttribute("sellerService", sellersDAO);
        return "sellers";
    }

    @GetMapping("/seller")
    public String sellerPage(@RequestParam(name = "sellerId") Long sellerId, Model model) {
        Sellers seller = sellersDAO.getById(sellerId);

        if (seller == null) {
            model.addAttribute("error_msg", "В базе нет заказчика с ID = " + sellerId);
            return "errorPage";
        }

        model.addAttribute("seller", seller);
        model.addAttribute("sellerService", sellersDAO);
        model.addAttribute("suppliesService", suppliesDAO);
        return "seller";
    }

    @GetMapping("/editSeller")
    public String editSellerPage(@RequestParam(name = "sellerId", required = false) Long sellerId, Model model) {
        if (sellerId == null) {
            model.addAttribute("seller", new Sellers());
            model.addAttribute("sellerService", sellersDAO);
            return "editSeller";
        }

        Sellers seller = sellersDAO.getById(sellerId);

        if (seller == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + sellerId);
            return "errorPage";
        }

        model.addAttribute("seller", seller);
        model.addAttribute("sellerService", sellersDAO);
        return "editSeller";
    }

    @PostMapping("/saveSeller")
    public String saveSellerPage(@RequestParam(name = "sellerId") Long sellerId,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "phone", required = false) String phone,
                                @RequestParam(name = "email", required = false) String email,
                                @RequestParam(name = "address", required = false) String address,
                                @RequestParam(name = "info", required = false) String info,
                                Model model) {
        Sellers seller = sellersDAO.getById(sellerId);
        boolean changeIsSuccessful = false;

        if (seller != null) {
            seller.setName(name);
        } else {
            seller = new Sellers(sellerId, name, phone, email, address, info);
        }

        model.addAttribute("error_msg", "Данные не сохранены");
        return "errorPage";
    }

    @PostMapping("/removeSeller")
    public String removeSellerPage(@RequestParam(name = "sellerId") Long sellerId) {
        sellersDAO.deleteById(sellerId);
        return "redirect:/sellers";
    }
}