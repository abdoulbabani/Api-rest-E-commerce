package com.ecommerce.serviceimpl;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.modal.Category;
import com.ecommerce.modal.Product;
import com.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional
@Service
public class ProductServiceImpl implements ProductService {


    private ProductDao productDao;
    private CategoryDao categoryDao;

    public ProductServiceImpl(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public Product addProductToCategory(Product product, long idCategory) {
        Category category = categoryDao.findById(idCategory).orElse(null);
        category.addProductToCategory(product);
        return productDao.save(product);
    }



    @Override
    public Product editProduct(Product product, long id) {
        Product existProduct = productDao.findById(id).orElse(null);
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPictureUrl(product.getPictureUrl());
        existProduct.setPrice(product.getPrice());
        return productDao.save(existProduct);
    }

    @Override
    public Product findProductById(long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(long id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findProductsForCategory(long idCategory) {
        Category category = categoryDao.findById(idCategory).orElse(null);
        return category.getProducts();
    }



    @Override
    public Product getProduct(long id) {
         return productDao.findById(id).orElse(null);
    }

}
