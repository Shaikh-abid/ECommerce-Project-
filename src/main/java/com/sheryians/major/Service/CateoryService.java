package com.sheryians.major.Service;

import com.sheryians.major.Repository.CateoreyRepository;
import com.sheryians.major.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateoryService {

    @Autowired
    CateoreyRepository cateoreyRepository;

    public void addCateorey(Category category) {
        cateoreyRepository.save(category);
    }

    public List<Category> getAllCateory() {
        return cateoreyRepository.findAll();
    }

    public void deleteCategory(int id) {
        cateoreyRepository.deleteById(id);
    }

    public Optional<Category> findById(int id) {
        return cateoreyRepository.findById(id);
    }
}
