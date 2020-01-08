package com.neuedu.shop.service.impl;

import com.neuedu.shop.common.CommonUtil;
import com.neuedu.shop.mapper.ProductMapper;
import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.Product;
import com.neuedu.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return mapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void update(Product product) {
        mapper.update(product);
    }

    ;

    @Override
    public Product findById(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public void insert(Product product,CommonsMultipartFile file, HttpServletRequest request) {
        try {
            String path = request.getServletContext().getRealPath("/") + "/images/"
                    + UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
            //创建文件
            File f = new File(path); // /images/041f6bdb3888444597c782dab5a6e6dbstand.png
            //判断path下的文件夹是否有
            File fileParent = f.getParentFile();
            //如果不存在
            if(!fileParent.exists()){
                //创建该路径下的文件夹
                fileParent.mkdirs();
            }

            try {
                //上传服务器
                // 服务器要存放上传的文件
                file.transferTo(f);
            }catch (Exception e) {
                e.printStackTrace();
            }
            // 保存数据库的路径
            String imgPath = null;
            // 把图片的相对路径保存至数据库
            imgPath = "/images" + path.substring(path.lastIndexOf("/"));
            product.setImgpath(imgPath);
            mapper.insert(product);
            //存到Eclipse路径下-->文件拷贝
            // 本地也要存放上传的文件
            CommonUtil.fileCopyToLocal(path,
                    "/Users/wangxiaoming/Desktop/shop/webapp/back"+imgPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByKeywords(String keywords) {
        return mapper.findByKeywords(keywords);
    }

    @Override
    public List<Product> lastedProduct() {
        return mapper.lastedProduct();
    }

    @Override
    public boolean ifHasProduct(Integer parentid) {
        if (mapper.countByParentId(parentid) != 0) {
            return true;
        }
        return false;
    }

}

