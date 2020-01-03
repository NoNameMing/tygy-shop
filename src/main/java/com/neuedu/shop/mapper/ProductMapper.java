package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> findAll();

    void delete(Integer id);

    void update(Product product);

    Product findById(Integer id);

    void insert(Product product);

    List<Product> findByKeywords(String keywords);

    List<Product > lastedProduct();
}
