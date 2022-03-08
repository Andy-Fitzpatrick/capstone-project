package org.launchcode.capstoneproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("supplies")
public class SupplyController {

    @GetMapping
    public String displayAllSupplies(Model model) {
        List<String> supplies = new ArrayList<>();
        supplies.add("Construction Paper");
        supplies.add("Copic Markers");
        supplies.add("Glitter");
        model.addAttribute("supplies", supplies);
        return "supplies/index";
    }

}
