package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.SupplyData;
import org.launchcode.capstoneproject.models.Supply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute(new Supply());
        return "supplies/create";
    }

    @PostMapping("create")
    public String processCreateSupplyForm(@ModelAttribute @Valid Supply newSupply,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Supply");
            return "supplies/create";
        }

        SupplyData.add(newSupply);
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

    @GetMapping("edit/supplyId")
    public String displayEditForm(Model model, @PathVariable int supplyId) {
        model.addAttribute("title", "Edit Supply ${supply.name} (id=${supply.id})");
        model.addAttribute("edit", SupplyData.getByID(supplyId));
        return "supplies/edit";
    }

    @PostMapping("edit")
    public String processEditForm(Model model, @RequestParam(required = false) int supplyId) {
        SupplyData.getByID(supplyId);
        return "redirect:";
    }


}
