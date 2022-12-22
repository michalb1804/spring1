package com.web.spring1.controller;

import com.web.spring1.model.Product;
import com.web.spring1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("products", productService.findAll());

        return "index";
    }

    @GetMapping("/details/{productId}")
    public String showDetails(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.findById(productId));

        return "details";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());

        return "form";
    }

    @GetMapping("/update/{productId}")
    public String updateForm(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.findById(productId));

        return "form";
    }

    @PostMapping
    public String createOrUpdate(Product product) {
        productService.save(product);

        return "redirect:/products";
    }


    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable Integer productId) {
        productService.delete(productId);

        return "redirect:/products";
    }


}
