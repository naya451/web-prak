package ru.msu.cmc.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.DAO.implementation.Warehouse_conditionDAO_Implementation;

@Controller
public class WarehouseController {

    @Autowired
    private final Warehouse_conditionDAO wcService = new Warehouse_conditionDAO_Implementation();

    @GetMapping("/wcMain")
    public String wcMainPage(Model model) {
        model.addAttribute("forPetsNotFree", wcService.getGetNotFreePositionsByType("for pets"));
        model.addAttribute("forChildrenNotFree", wcService.getGetNotFreePositionsByType("for children"));
        model.addAttribute("clothesNotFree", wcService.getGetNotFreePositionsByType("clothes"));
        model.addAttribute("productsNotFree", wcService.getGetNotFreePositionsByType("products"));
        model.addAttribute("devicesNotFree", wcService.getGetNotFreePositionsByType("devices"));
        model.addAttribute("wcService", wcService);
        return "wcMain";
    }

    @GetMapping("/forButton")
    public String editSellerPage(Model model) {
        model.addAttribute("forPetsNotFree", wcService.getGetNotFreePositionsByType("for pets"));
        model.addAttribute("forChildrenNotFree", wcService.getGetNotFreePositionsByType("for children"));
        model.addAttribute("clothesNotFree", wcService.getGetNotFreePositionsByType("clothes"));
        model.addAttribute("productsNotFree", wcService.getGetNotFreePositionsByType("products"));
        model.addAttribute("devicesNotFree", wcService.getGetNotFreePositionsByType("devices"));
        model.addAttribute("wcService", wcService);
        return "wcLookup";
    }
    @PostMapping("/lookupPlace")
    public String lookupPage(@RequestParam(name = "clothes", required = false) Long clothes,
                             @RequestParam(name = "forChildren", required = false) Long forChildren,
                             @RequestParam(name = "forPets", required = false) Long forPets,
                             @RequestParam(name = "products", required = false) Long products,
                             @RequestParam(name = "devices", required = false) Long devices,
                             Model model) {

        if ((clothes <= 40 - wcService.getGetNotFreePositionsByType("clothes").size()) &&
                (forChildren <= 40 - wcService.getGetNotFreePositionsByType("for children").size()) &&
                (forPets <= 40 - wcService.getGetNotFreePositionsByType("for pets").size()) &&
                (products <= 40 - wcService.getGetNotFreePositionsByType("products").size()) &&
                (devices <= 40 - wcService.getGetNotFreePositionsByType("devices").size())) {
            return "wcSuccess";
        } else {
            return "wcFail";
        }
    }
}