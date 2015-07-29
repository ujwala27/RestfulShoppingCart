package com.shop.restService;

import com.shop.dao.GenericDao;
import com.shop.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ujwala Chintala
 * Date: 10/17/14
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductService {

    @Inject
    private GenericDao<Product> dao;

    public ProductService() {
        dao = new GenericDao<Product>();
        dao.setClassType(Product.class);
    }

    public List<Product> findAll() {
        return dao.findAll();
    }

    public int insert(Product product) {
        return dao.insert(product);
    }

    public void delete(int productId) {
        dao.delete(productId);
    }

    public Product update(Product product) {
        return dao.update(product);
    }

    public int save(Product product) {
        return dao.save(product);
    }

    public List<Product> getAll() {
        return dao.getAll();
    }

    public Product getById(int productId) {
        return dao.getById(productId);
    }


    public List<Product> getById(String productId) {
        String column = "a.product";
        return dao.getByName("select * from product a where a.product = ", productId, column);
    }


}
