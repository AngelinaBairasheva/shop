package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Categories;
import ru.dz.labs.api.repository.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public List<Categories> getAllCategories() {
        return categoriesRepository.getAllCategories();
    }

    @Transactional
    public void addCategory(Categories categories) {
        categoriesRepository.addCategory(categories);
    }

    @Transactional
    public void updateCategory(Categories categories) {
        categoriesRepository.updateCategory(categories);
    }

    @Transactional
    public List<Categories> getRootCategories() {
        return categoriesRepository.getRootCategories();
    }
    @Transactional
    public Categories getCategoryById(Long id) {
        return categoriesRepository.getCategoryById(id);
    }

    @Transactional
    public void deleteCategory(Categories categories) {
        categoriesRepository.deleteCategory(categories);
    }
}

