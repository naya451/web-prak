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

@Controller
public class GoodController {

    @Autowired
    private final GoodsDAO goodsDAO = new GoodsDAO_Implementation();

    @Autowired
    private final Warehouse_conditionDAO wcDAO = new Warehouse_conditionDAO_Implementation();


    @GetMapping("/goods")
    public String peopleListPage(Model model) {
        List<Goods> goods = (List<Goods>) goodsDAO.getAll();
        model.addAttribute("goods", goods);
        model.addAttribute("goodService", goodsDAO);
        return "goods";
    }

    @GetMapping("/good")
    public String goodPage(@RequestParam(name = "goodId") Long goodId, Model model) {
        Goods good = goodsDAO.getById(goodId);

        if (good == null) {
            model.addAttribute("error_msg", "В базе нет товара с ID = " + goodId);
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
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "type") String type,
                                @RequestParam(name = "size1", required = false) Long size1,
                                @RequestParam(name = "size2", required = false) Long size2,
                                @RequestParam(name = "size3", required = false) Long size3,
                                @RequestParam(name = "time", required = false) Long time,
                                @RequestParam(name = "description", required = false) String description,
                                @RequestParam(name = "measurement", required = false) String measurement,
                                Model model) {
        Goods good = goodsDAO.getById(goodId);
        boolean changeIsSuccessful = false;

        if (good != null) {
            good.setName(name);
        } else {
            good = new Goods(goodId, name, type, size1, size2, size3, time, description, measurement);
        }

        model.addAttribute("error_msg", "Данные не сохранены");
        return "errorPage";
    }

    @PostMapping("/removeGood")
    public String removeGoodPage(@RequestParam(name = "goodId") Long goodId) {
        goodsDAO.deleteById(goodId);
        return "redirect:/goods";
    }
}