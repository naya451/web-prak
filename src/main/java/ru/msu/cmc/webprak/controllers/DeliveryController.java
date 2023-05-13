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
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class DeliveryController {

    @Autowired
    private final DeliveriesDAO deliveriesDAO = new DeliveriesDAO_Implementation();

    @Autowired
    private final BuyersDAO buyersDAO = new BuyersDAO_Implementation();

    @Autowired
    private final Goods_in_deliveryDAO goodsDAO = new Goods_in_deliveryDAO_Implementation();

    @Autowired
    private final GoodsDAO allGoodsDAO = new GoodsDAO_Implementation();

    @Autowired
    private final Warehouse_conditionDAO wcService = new Warehouse_conditionDAO_Implementation();

    @GetMapping("/deliveries")
    public String deliveriesListPage(Model model) {
        List<Deliveries> deliveries = (List<Deliveries>) deliveriesDAO.getAll();
        model.addAttribute("deliveries", deliveries);
        model.addAttribute("deliveryService", deliveriesDAO);
        return "deliveries";
    }

    @GetMapping("/delivery")
    public String deliveryPage(@RequestParam(name = "deliveryId") Long deliveryId, Model model) {
        Deliveries delivery = deliveriesDAO.getById(deliveryId);

        if (delivery == null) {
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + deliveryId);
            return "errorPage";
        }

        model.addAttribute("delivery", delivery);
        model.addAttribute("deliveryService", deliveriesDAO);
        model.addAttribute("goodsService", goodsDAO);
        model.addAttribute("allGoodsService", allGoodsDAO);
        return "delivery";
    }

    @GetMapping("/editDelivery")
    public String editDeliveryPage(@RequestParam(name = "deliveryId", required = false) Long deliveryId, Model model) {
        if (deliveryId == null) {
            model.addAttribute("delivery", new Deliveries());
            model.addAttribute("deliveryService", deliveriesDAO);
            return "editDelivery";
        }

        Deliveries delivery = deliveriesDAO.getById(deliveryId);

        if (delivery == null) {
            model.addAttribute("error_msg", "В базе нет поставщика с ID = " + deliveryId);
            return "errorPage";
        }

        model.addAttribute("delivery", delivery);
        model.addAttribute("deliveryService", deliveriesDAO);
        model.addAttribute("wcService", wcService);
        return "editDelivery";
    }

    @PostMapping("/saveDelivery")
    public String saveDeliveryPage(@RequestParam(name = "deliveryId") Long deliveryId,
                                @RequestParam(name = "deliveryDateTime") Date date,
                                @RequestParam(name = "deliveryComment", required = false) String info,
                                @RequestParam(name = "deliveryBuyerName", required = true) String buyerName,
                                Model model) {
        Deliveries delivery = deliveriesDAO.getById(deliveryId);
        List<Deliveries> deliveries = deliveriesDAO.getAllDeliveries();
        boolean changeIsSuccessful = false;

        if (delivery != null) {
            delivery.setDate_time(date);
            if (info!= null) {
                delivery.setComment(info);
            }
            if (buyerName!= null) {
                if (buyersDAO.getAllBuyersByName(buyerName) != null && buyersDAO.getAllBuyersByName(buyerName).size() == 1) {
                    delivery.setBuyer(buyersDAO.getAllBuyersByName(buyerName).get(0));
                }
                delivery.setBuyer_name(buyerName);
            }
            deliveriesDAO.update(delivery);
        } else {
            delivery = new Deliveries(deliveryId, date, buyersDAO.getAllBuyersByName(buyerName).get(0), info, buyerName);
            deliveriesDAO.save(delivery);
        }
        return "index";
    }


    @GetMapping("/searchDelivery")
    public String searchEmployee(@RequestParam(name = "date1", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                                 @RequestParam(name = "date2", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                                 @RequestParam(name = "sorting", required = false) String sortingId,
                                 @RequestParam(name = "asc", required = false) String asc,
                                 Model model) {

        List<Deliveries> deliveries = null;
        if (Objects.equals(sortingId, "Дата")) {
                if (Objects.equals(asc, "по убыванию")) {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithDateDESC(date1, date2);
                } else {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithDateASC(date1, date2);
                }
        } else if (Objects.equals(sortingId, "Количество товаров")) {
                if (Objects.equals(asc, "по убыванию")) {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(date1, date2);
                } else {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(date1, date2);
                }
        } else if (Objects.equals(sortingId, "Имя заказчика")) {
                if (Objects.equals(asc, "по убыванию")) {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithBuyerNameDESC(date1, date2);
                } else {
                    deliveries = deliveriesDAO.getAllDeliveriesByPeriodSortedWithBuyerNameASC(date1, date2);
                }
        } else {
                deliveries = deliveriesDAO.getAllDeliveriesByPeriod(date1, date2);
        }
        model.addAttribute("deliveries", deliveries);
        model.addAttribute("deliveriesDAO", deliveriesDAO);
        return "deliveries";
    }

    @PostMapping("/removeDelivery")
    public String removeDeliveryPage(@RequestParam(name = "deliveryId") Long deliveryId) {
        deliveriesDAO.deleteById(deliveryId);
        return "redirect:/deliveries";
    }
}