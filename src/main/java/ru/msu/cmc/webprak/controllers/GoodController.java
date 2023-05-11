package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.GoodsDAO;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.DAO.implementation.GoodsDAO_Implementation;
import ru.msu.cmc.webprak.DAO.implementation.Warehouse_conditionDAO_Implementation;
import ru.msu.cmc.webprak.models.Goods;

import java.util.List;
import java.util.Objects;

@Controller
public class GoodController {

    @Autowired
    private final GoodsDAO goodsDAO = new GoodsDAO_Implementation();

    @Autowired
    private final Warehouse_conditionDAO wcDAO = new Warehouse_conditionDAO_Implementation();

    @GetMapping("/goods")
    public String goodsListPage(Model model) {
        List<Goods> goods = (List<Goods>) goodsDAO.getAll();
        model.addAttribute("goods", goods);
        model.addAttribute("goodService", goodsDAO);
        return "goods";
    }

    @GetMapping("/good")
    public String goodPage(@RequestParam(name = "goodId") Long goodId, Model model) {
        Goods good = goodsDAO.getById(goodId);

        if (good == null) {
            model.addAttribute("error_msg", "В базе нет заказчика с ID = " + goodId);
            return "errorPage";
        }

        model.addAttribute("good", good);
        model.addAttribute("goodService", goodsDAO);
        model.addAttribute("wcService", wcDAO);
        return "good";
    }

    @GetMapping("/editGood")
    public String editGoodPage(@RequestParam(name = "goodId", required = false) Long goodId, Model model) {
        if (goodId == null) {
            model.addAttribute("good", new Goods());
            model.addAttribute("goodService", goodsDAO);
            return "editGood";
        }

        Goods good = goodsDAO.getById(goodId);

        if (good == null) {
            model.addAttribute("error_msg", "В базе нет человека с ID = " + goodId);
            return "errorPage";
        }

        model.addAttribute("good", good);
        model.addAttribute("goodService", goodsDAO);
        return "editGood";
    }

    @PostMapping("/saveGood")
    public String saveGoodPage(@RequestParam(name = "goodId") Long goodId,
                               @RequestParam(name = "goodName") String name,
                               @RequestParam(name = "goodType", required = true) String type,
                               @RequestParam(name = "goodSize1", required = false) Long size1,
                               @RequestParam(name = "goodSize2", required = false) Long size2,
                               @RequestParam(name = "goodSize3", required = false) Long size3,
                               @RequestParam(name = "goodTime", required = false) Long time,
                               @RequestParam(name = "goodMeasurement", required = false) String measurement,
                               @RequestParam(name = "goodDescription", required = false) String info,
                                Model model) {
        Goods good = goodsDAO.getById(goodId);
        List<Goods> goods = goodsDAO.getAllGoods();
        boolean changeIsSuccessful = false;

        if (good != null) {
            good.setName(name);
            if (type!= null) {
                good.setType(type);
            }
            if (size1!= null) {
                good.setSize1(size1);
            }
            if (size2!= null) {
                good.setSize2(size2);
            }
            if (size3!= null) {
                good.setSize3(size3);
            }
            if (time!= null) {
                good.setTime_of_keeping(time);
            }
            if (measurement!= null) {
                good.setMeasurement(measurement);
            }
            if (info!= null) {
                good.setDescription(info);
            }
            goodsDAO.update(good);
        } else {
            good = new Goods(goodId, name, type, size1, size2, size3, time, info, measurement);
            goodsDAO.save(good);
        }
        return "index";
    }


    @GetMapping("/searchGood")
    public String searchEmployee(@RequestParam(required = true) String name,
                                 @RequestParam(required = false) String sortingId,
                                 @RequestParam(required = false) String asc,
                                 Model model) {

        List<Goods> goods;
        if (sortingId.equals("Имя")) {
            if (Objects.equals(asc, "по убыванию")) {
                goods = goodsDAO.getAllGoodsByNameSortedWithNameDESC(name);
            } else {
                goods = goodsDAO.getAllGoodsByNameSortedWithNameASC(name);
            }
        } else if (sortingId.equals("Срок хранения")) {
            if (Objects.equals(asc, "по убыванию")) {
                goods = goodsDAO.getAllGoodsByNameSortedWithTimeOfKeepingDESC(name);
            } else {
                goods = goodsDAO.getAllGoodsByNameSortedWithTimeOfKeepingASC(name);
            }
        } else if (sortingId.equals("Наличие")) {
            if (Objects.equals(asc, "по убыванию")) {
                goods = goodsDAO.getAllGoodsByNameSortedWithAvailabilityDESC(name);
            } else {
                goods = goodsDAO.getAllGoodsByNameSortedWithAvailabilityASC(name);
            }
        } else {
            goods = goodsDAO.getAllGoodsByName(name);
        }

        model.addAttribute("goods", goods);
        model.addAttribute("goodsDAO", goodsDAO);
        return "goods";
    }

    @PostMapping("/removeGood")
    public String removeGoodPage(@RequestParam(name = "goodId") Long goodId) {
        goodsDAO.deleteById(goodId);
        return "redirect:/goods";
    }
}