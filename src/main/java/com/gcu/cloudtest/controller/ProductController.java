package com.gcu.cloudtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.cloudtest.model.Product;
import com.gcu.cloudtest.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products")
    public String viewProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return "redirect:/";
        }

        model.addAttribute("product", product);
        return "editproduct";
    }

    @PostMapping("/products/update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}