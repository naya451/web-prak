package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.*;
import ru.msu.cmc.webprak.DAO.implementation.*;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class SupplyController {

    @Autowired
    private final SuppliesDAO suppliesDAO = new SuppliesDAO_Implementation();

    @Autowired
    private final SellersDAO sellersDAO = new SellersDAO_Implementation();

    @Autowired
    private final Goods_in_supplyDAO goodsDAO = new Goods_in_supplyDAO_Implementation();

    @Autowired
    private final GoodsDAO allGoodsDAO = new GoodsDAO_Implementation();

    @Autowired
    private final Warehouse_conditionDAO wcService = new Warehouse_conditionDAO_Implementation();

    @GetMapping("/supplies")
    public String suppliesListPage(Model model) {
        List<Supplies> supplies = (List<Supplies>) suppliesDAO.getAll();
        model.addAttribute("supplies", supplies);
        model.addAttribute("supplyService", suppliesDAO);
        return "supplies";
    }

    @GetMapping("/supply")
    public String supplyPage(@RequestParam(name = "supplyId") Long supplyId, Model model) {
        Supplies supply = suppliesDAO.getById(supplyId);

        if (supply == null) {
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + supplyId);
            return "errorPage";
        }

        model.addAttribute("supply", supply);
        model.addAttribute("supplyService", suppliesDAO);
        model.addAttribute("goodsService", goodsDAO);
        model.addAttribute("allGoodsService", allGoodsDAO);
        return "supply";
    }

    @GetMapping("/editSupply")
    public String editSupplyPage(@RequestParam(name = "supplyId", required = false) Long supplyId, Model model) {
        if (supplyId == null) {
            model.addAttribute("supply", new Supplies());
            model.addAttribute("supplyService", suppliesDAO);
            return "editSupply";
        }

        Supplies supply = suppliesDAO.getById(supplyId);

        if (supply == null) {
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + supplyId);
            return "errorPage";
        }

        model.addAttribute("supply", supply);
        model.addAttribute("supplyService", suppliesDAO);
        model.addAttribute("wcService", wcService);
        return "editSupply";
    }

    @PostMapping("/saveSupply")
    public String saveSupplyPage(@RequestParam(name = "supplyId") Long supplyId,
                                @RequestParam(name = "supplyDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                @RequestParam(name = "supplyComment", required = false) String info,
                                @RequestParam(name = "supplySellerName", required = true) String sellerName,
                                Model model) {
        Supplies supply = suppliesDAO.getById(supplyId);
        List<Supplies> supplies = suppliesDAO.getAllSupplies();
        boolean changeIsSuccessful = false;

        if (supply != null) {
            supply.setDate_time(date);
            if (info!= null) {
                supply.setComment(info);
            }
            if (sellerName!= null) {
                if (sellersDAO.getAllSellersByName(sellerName) != null && sellersDAO.getAllSellersByName(sellerName).size() == 1) {
                    supply.setSeller(sellersDAO.getAllSellersByName(sellerName).get(0));
                }
                supply.setSeller_name(sellerName);
            }
            suppliesDAO.update(supply);
        } else {
            supply = new Supplies(supplyId, date, sellersDAO.getAllSellersByName(sellerName).get(0), info, sellerName);
            suppliesDAO.save(supply);
        }
        return "index";
    }


    @GetMapping("/searchSupply")
    public String searchEmployee(@RequestParam(name = "date1", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                                 @RequestParam(name = "date2", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                                 @RequestParam(name = "sortingId", required = false) String sortingId,
                                 @RequestParam(name = "asc", required = false) String asc,
                                 Model model) {

        List<Supplies> supplies = null;
        if (Objects.equals(sortingId, "Дата")) {
                if (Objects.equals(asc, "по убыванию")) {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithDateDESC(date1, date2);
                } else {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithDateASC(date1, date2);
                }
        } else if (Objects.equals(sortingId, "Количество товаров")) {
                if (Objects.equals(asc, "по убыванию")) {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(date1, date2);
                } else {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(date1, date2);
                }
        } else if (Objects.equals(sortingId, "Имя поставщика")) {
                if (Objects.equals(asc, "по убыванию")) {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithSellerNameDESC(date1, date2);
                } else {
                    supplies = suppliesDAO.getAllSuppliesByPeriodSortedWithSellerNameASC(date1, date2);
                }
        } else {
                supplies = suppliesDAO.getAllSuppliesByPeriod(date1, date2);
        }
        model.addAttribute("supplies", supplies);
        model.addAttribute("suppliesDAO", suppliesDAO);
        return "supplies";
    }

    @PostMapping("/removeSupply")
    public String removeSupplyPage(@RequestParam(name = "supplyId") Long supplyId) {
        suppliesDAO.deleteById(supplyId);
        return "redirect:/supplies";
    }
}