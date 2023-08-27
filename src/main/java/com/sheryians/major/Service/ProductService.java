package com.sheryians.major.Service;

import com.sheryians.major.Repository.ProductRepository;
import com.sheryians.major.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public void addProducts(Product product) {
        productRepository.save(product);
    }
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProductsByCategoryID(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
}
