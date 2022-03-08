package org.launchcode.capstoneproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("supplies")
public class SupplyController {

    private static List<String> supplies = new ArrayList<>();

    @GetMapping
    public String displayAllSupplies(Model model) {
        model.addAttribute("supplies", supplies);
        return "supplies/index";
    }

    @GetMapping("create")
    public String renderCreateSupplyForm() {
        return "supplies/create";
    }

    @PostMapping("create")
    public String createSupply(@RequestParam String supplyName) {
        supplies.add(supplyName);
        return "redirect:";
    }


}
