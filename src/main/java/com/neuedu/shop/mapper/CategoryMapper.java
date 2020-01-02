package com.neuedu.shop.mapper;

import com.neuedu.shop.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> findAll();

    void delete(Integer id);

    void addRootCategory(Category category);

    List<Category> findToTree();

    /**
     * 添加子类别
     */
    void addChildCategory(Category category);

    /**
     * 传父级别的id值，得grade
     * @param pid
     * @return
     */
    int findByParentId(int pid);

    /**
     * 更新父节点的叶子结点 status 为非
     * @param pid 父级别的id值
     */
    void updateParent(int pid);

    Category findById(int id);

    /**
     * 商品修改描述
     * @param category
     */
    void modifyCategoryDesc(Category category);

    /**
     * 查询类别级别为3的所有类别
     */
    List<Category> findThree();
}
