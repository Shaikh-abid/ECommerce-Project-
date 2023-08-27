package com.sheryians.major.Configuration;


import com.sheryians.major.Service.ProductService;
import com.sheryians.major.global.GolbalDara;
import com.sheryians.major.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GolbalDara.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GolbalDara.cart.size());
        model.addAttribute("total", GolbalDara.cart.stream().mapToDouble(Product::getPrice).sum());

        model.addAttribute("cart", GolbalDara.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GolbalDara.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", GolbalDara.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }






}
