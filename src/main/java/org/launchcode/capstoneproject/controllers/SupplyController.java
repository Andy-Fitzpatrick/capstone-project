package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.SupplyRepository;
import org.launchcode.capstoneproject.models.Supply;
import org.launchcode.capstoneproject.models.SupplyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("supplies")
public class SupplyController {

    @Autowired
    private SupplyRepository supplyRepository;

    @GetMapping
    public String displayAllSupplies(Model model) {
        model.addAttribute("title", "All Supplies");
        model.addAttribute("supplies", supplyRepository.findAll());
        return "supplies/index";
    }

    @GetMapping("create")
    public String renderCreateSupplyForm(Model model) {
        model.addAttribute("title", "Create Supply");
        model.addAttribute(new Supply());
        model.addAttribute("categories", SupplyCategory.values());
        return "supplies/create";
    }

    @PostMapping("create")
    public String processCreateSupplyForm(@ModelAttribute @Valid Supply newSupply,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Supply");
            return "supplies/create";
        }

        supplyRepository.save(newSupply);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteSupplyForm(Model model) {
        model.addAttribute("title", "Delete Supplies");
        model.addAttribute("supplies", supplyRepository.findAll());
        return "supplies/delete";
    }

    @PostMapping("delete")
    public String processDeleteSuppliesForm(@RequestParam(required = false) int[] supplyIds) {

        if (supplyIds != null) {
            for (int id : supplyIds) {
                supplyRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

//    @GetMapping("edit/{supplyId}")
//    public String displayEditForm(Model model, @PathVariable int supplyId) {
//        model.addAttribute("title", "Edit Supply ${supply.name} (id=${supply.id})");
//        model.addAttribute("edit", supplyRepository.findById(supplyId));
//        return "supplies/edit";
//    }
//
//    @PostMapping("edit")
//    public String processEditForm(Supply supply, @RequestParam(required = false) int supplyId, String name, String description,
//                                  String location, String color, String amount, String brand, SupplyCategory category) {
//        SupplyData.getByID(supplyId);
//        supply.setName(supply.getName());
//        supply.setDescription(supply.getDescription());
//        supply.setLocation(supply.getLocation());
//        supply.setColor(supply.getColor());
//        supply.setAmount(supply.getAmount());
//        supply.setBrand(supply.getBrand());
//        supply.setCategory(supply.getCategory());
//
//        return "redirect:";
//    }


}
