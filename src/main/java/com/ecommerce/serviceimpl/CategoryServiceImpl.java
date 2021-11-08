package com.ecommerce.serviceimpl;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.modal.Category;
import com.ecommerce.modal.User;
import com.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;
    private UserDao userDao;

    public CategoryServiceImpl(CategoryDao categoryDao, UserDao userDao) {
        this.categoryDao = categoryDao;
        this.userDao = userDao;
    }
    @Override
    public Category addCategoryToUser(Category category, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        user.addCategoryToUser(category);
        return categoryDao.save(category);
    }

    @Override
    public Category editCategory(Category category, long id) {
        Category existsCategory = categoryDao.findById(id).orElse(null);
        existsCategory.setName(category.getName());
        return categoryDao.save(existsCategory);
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(long id) {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> findCategoriesForUser(long id) {
        User user = userDao.findById(id).orElse(null);
        return user.getCategories();
    }
}
