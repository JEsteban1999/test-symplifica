package com.symplifica.test.controller;

import com.symplifica.test.entity.Product;
import com.symplifica.test.service.OrderService;
import com.symplifica.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/")
    public String showOrderPage(Model model) {
        List<Product> availableProducts = productService.getAllProducts();
        model.addAttribute("avaliableProducts", availableProducts);
        model.addAttribute("orders", orderService.getAllOrders());
        return "index";
    }

    @PostMapping("/generate-order")
    public String generateOrder(List<Integer> selectedProducts, Model model) {
        orderService.createOrder(selectedProducts);
        return "redirect:/";
    }
}
