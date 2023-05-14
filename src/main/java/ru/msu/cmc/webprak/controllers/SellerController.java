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
import java.util.Objects;

@Controller
public class SellerController {

    @Autowired
    private final SellersDAO sellersDAO = new SellersDAO_Implementation();

    @Autowired
    private final SuppliesDAO suppliesDAO = new SuppliesDAO_Implementation();

    @GetMapping("/sellers")
    public String sellersListPage(Model model) {
        List<Sellers> sellers = (List<Sellers>) sellersDAO.getAll();
        model.addAttribute("sellers", sellers);
        model.addAttribute("sellerService", sellersDAO);
        return "sellers";
    }

    @GetMapping("/seller")
    public String sellerPage(@RequestParam(name = "sellerId") Long sellerId, Model model) {
        Sellers seller = sellersDAO.getById(sellerId);

        if (seller == null) {
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + sellerId);
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
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + sellerId);
            return "errorPage";
        }

        model.addAttribute("seller", seller);
        model.addAttribute("sellerService", sellersDAO);
        return "editSeller";
    }

    @PostMapping("/saveSeller")
    public String saveSellerPage(@RequestParam(name = "sellerId") Long sellerId,
                                @RequestParam(name = "sellerName") String name,
                                @RequestParam(name = "sellerPhone", required = false) String phone,
                                @RequestParam(name = "sellerEmail", required = false) String email,
                                @RequestParam(name = "sellerAddress", required = false) String address,
                                @RequestParam(name = "sellerDescription", required = false) String info,
                                Model model) {
        List<Sellers> sellers = sellersDAO.getAllSellers();
        Sellers seller = null;
        if (sellerId != 0) {
            seller = sellersDAO.getById(sellerId);
        }
        if (sellerId != 0 && seller != null) {
            seller.setName(name);
            if (phone!= null) {
                seller.setPhone(phone);
            }
            if (email!= null) {
                seller.setEmail(email);
            }
            if (address!= null) {
                seller.setAddress(address);
            }
            if (info!= null) {
                seller.setDescription(info);
            }
            sellersDAO.update(seller);
        } else {
            seller = new Sellers();
            seller.setName(name);
            if (phone!= null) {
                seller.setPhone(phone);
            }
            if (email!= null) {
                seller.setEmail(email);
            }
            if (address!= null) {
                seller.setAddress(address);
            }
            if (info!= null) {
                seller.setDescription(info);
            }
            sellersDAO.save(seller);
        }
        return "index";
    }


    @GetMapping("/searchSeller")
    public String searchEmployee(@RequestParam(required = true) String name,
                                 @RequestParam(required = false) String sortingId,
                                 @RequestParam(required = false) String asc,
                                 Model model) {

        List<Sellers> sellers;
        if (sortingId.equals("Имя")) {
                if (Objects.equals(asc, "по убыванию")) {
                    sellers = sellersDAO.getAllSellersByNameSortedWithNameDESC(name);
                } else {
                    sellers = sellersDAO.getAllSellersByNameSortedWithNameASC(name);
                }
        } else if (sortingId.equals("Количество поставок за последний год")) {
                if (Objects.equals(asc, "по убыванию")) {
                    sellers = sellersDAO.getAllSellersByNameSortedWithYearsSuppliesDESC(name);
                } else {
                    sellers = sellersDAO.getAllSellersByNameSortedWithYearsSuppliesASC(name);
                }
        } else if (sortingId.equals("Общее количество поставок")) {
                if (Objects.equals(asc, "по убыванию")) {
                    sellers = sellersDAO.getAllSellersByNameSortedWithSuppliesDESC(name);
                } else {
                    sellers = sellersDAO.getAllSellersByNameSortedWithSuppliesASC(name);
                }
        } else {
                sellers = sellersDAO.getAllSellersByName(name);
        }

        model.addAttribute("sellers", sellers);
        model.addAttribute("sellersDAO", sellersDAO);
        return "sellers";
    }

    @PostMapping("/removeSeller")
    public String removeSellerPage(@RequestParam(name = "sellerId") Long sellerId) {
        sellersDAO.deleteById(sellerId);
        return "redirect:/sellers";
    }
}