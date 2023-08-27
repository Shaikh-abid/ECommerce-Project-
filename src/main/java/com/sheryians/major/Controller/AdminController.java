package com.sheryians.major.Controller;

import com.sheryians.major.Service.CateoryService;
import com.sheryians.major.Service.ProductService;
import com.sheryians.major.dta.ProductDTO;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    public static String uploadDri = System.getProperty("user.dir")
                                    + "/src/main/resources/static/productImages";

    @Autowired
    CateoryService cateoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", cateoryService.getAllCateory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        cateoryService.addCateorey(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id) {
        cateoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> optionalCategory = cateoryService.findById(id);
        if (optionalCategory.isPresent()) {
            model.addAttribute("category", optionalCategory.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }







    // Product Section
    @GetMapping("/admin/products")
    public String getProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productAddGet(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", cateoryService.getAllCateory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam ("imgName")String imgName) throws IOException {
        Product product =  new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(cateoryService.findById(productDTO.getCategoryId()).get());
        product.setWeight(productDTO.getWeight());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String ImageUUID;
        if (!file.isEmpty()) {
            ImageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDri, ImageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            ImageUUID = imgName;
        }
        product.setImageName(ImageUUID);
        productService.addProducts(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.removeProduct((long) id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
       Product product = productService.getProductById(id).get();
       ProductDTO productDTO = new ProductDTO();
       productDTO.setId(product.getId());
       productDTO.setName(product.getName());
       productDTO.setPrice(product.getPrice());
       productDTO.setWeight(product.getWeight());
       productDTO.setDescription(product.getDescription());
       productDTO.setCategoryId(product.getCategory().getId());
       productDTO.setImageName(product.getImageName());
       model.addAttribute("categories", cateoryService.getAllCateory());
       model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }

}
