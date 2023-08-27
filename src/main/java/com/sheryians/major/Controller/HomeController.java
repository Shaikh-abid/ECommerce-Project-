package com.sheryians.major.Controller;

import com.sheryians.major.Service.CateoryService;
import com.sheryians.major.Service.ProductService;
import com.sheryians.major.global.GolbalDara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Path;

@Controller
public class HomeController {
    @Autowired
    CateoryService cateoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", GolbalDara.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", cateoryService.getAllCateory());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount", GolbalDara.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopProductbyCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories", cateoryService.getAllCateory());
        model.addAttribute("cartCount", GolbalDara.cart.size());
        model.addAttribute("products", productService.getAllProductsByCategoryID(id));

        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("cartCount", GolbalDara.cart.size());
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }


}
