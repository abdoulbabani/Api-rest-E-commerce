package com.ecommerce.serviceimpl;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.TagDao;
import com.ecommerce.modal.Product;
import com.ecommerce.modal.Tag;
import com.ecommerce.service.TagService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class TagServiceeImpl implements TagService {

    private TagDao tagDao;
    private ProductDao productDao;

    public TagServiceeImpl(TagDao tagDao, ProductDao productDao) {
        this.tagDao = tagDao;
        this.productDao = productDao;
    }

    @Override
    public void addTagToProduct(long idProduct, long idTag) {
        Product product = productDao.findById(idProduct).orElse(null);
        Tag tag = tagDao.findById(idTag).orElse(null);
        tag.addProductToTag(product);
        product.addTag(tag);

    }

    @Override
    public List<Tag> findTagsForProduct(long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        return product.getTags();
    }

    @Override
    public void deleteTagFromProduct(long idTag, long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        Tag tag = tagDao.findById(idTag).orElse(null);
        product.getTags().remove(tag);

    }

    @Override
    public Tag addTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public void deleteTag(long id) {
        tagDao.deleteById(id);
    }

    @Override
    public Tag findTagById(long id) {
        return tagDao.findById(id).orElse(null);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagDao.findAll();
    }

    @Override
    public List<Product> findProductsForTag(long idTag) {
        Tag tag = tagDao.findById(idTag).orElse(null);
        return tag.getProducts();
    }

}
