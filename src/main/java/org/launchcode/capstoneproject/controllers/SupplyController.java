package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.SupplyData;
import org.launchcode.capstoneproject.models.Supply;
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

    @GetMapping
    public String displayAllSupplies(Model model) {
        model.addAttribute("title", "All Supplies");
        model.addAttribute("supplies", SupplyData.getAll());
        return "supplies/index";
    }

    @GetMapping("create")
    public String renderCreateSupplyForm(Model model) {
        model.addAttribute("title", "Create Supply");
        return "supplies/create";
    }

    @PostMapping("create")
    public String processCreateSupplyForm(@RequestParam String supplyName, @RequestParam String supplyDescription) {
        SupplyData.add(new Supply(supplyName, supplyDescription));
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteSupplyForm(Model model) {
        model.addAttribute("title", "Delete Supplies");
        model.addAttribute("supplies", SupplyData.getAll());
        return "supplies/delete";
    }

    @PostMapping("delete")
    public String processDeleteSuppliesForm(@RequestParam(required = false) int[] supplyIds) {

        if (supplyIds != null) {
            for (int id : supplyIds) {
                SupplyData.remove(id);
            }
        }
        return "redirect:";

    }

}
