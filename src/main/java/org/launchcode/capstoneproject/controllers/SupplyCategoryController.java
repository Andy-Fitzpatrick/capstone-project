package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.SupplyCategoryRepository;
import org.launchcode.capstoneproject.models.SupplyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("categories")
public class SupplyCategoryController {

    @Autowired
    private SupplyCategoryRepository supplyCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", supplyCategoryRepository.findAll());
        return "categories/index";
    }

    @GetMapping("create")
    public String renderCreateSupplyCategoryForm(Model model) {
        model.addAttribute("title", "New Category");
        model.addAttribute("category", new SupplyCategory());
        return "categories/create";
    }

    @PostMapping("create")
    public String processCreateSupplyCategoryForm(
            @ModelAttribute @Valid SupplyCategory supplyCategory,
            Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "New Category");
            model.addAttribute(new SupplyCategory());
            return "categories/create";
        }

        supplyCategoryRepository.save(supplyCategory);
        return "redirect:";
    }


}
