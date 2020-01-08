package com.neuedu.shop.controller;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.service.CategoryService;
import com.neuedu.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Transactional
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private ProductService productService;

    @RequestMapping("/back/findAll.category")
    public String findAll(ModelMap map) {
        List<Category> categories = service.findAll();
        map.addAttribute("categories", categories);
        return "forward:category_list.jsp";
    }

    @RequestMapping("/back/delete.category")
    public String delete(Integer id, ModelMap modelMap) {
        // 0.构建一个类别
        try {
            Category category = service.findById(id);
            int pid = category.getPid();
            int childCnt = service.countChild(id);
            if (childCnt == 0) { // 1.判断是否有孩子
                if (!productService.ifHasProduct(category.getId())) { // 2.判断类别下是否有商品
                    if (service.judgeParentStatus(pid)) { // 3.父类是否需要升级
                        service.delete(id); // 4.删除并更新
                        service.updateParentAfterDelete(pid);
                        modelMap.addAttribute("category_msg", "删除成功!");
                        return "forward:findAll.category";
                    } else {
                        service.delete(id); // 4.仅删除
                        modelMap.addAttribute("category_msg", "删除成功!");
                        return "forward:findAll.category";
                    }
                } else {
                    modelMap.addAttribute("category_msg", "该类别下还有商品，无法删除!");
                    return "forward:findAll.category";
                }
            } else {
                modelMap.addAttribute("category_msg", "该类别下还有类别，无法删除!");
                return "forward:findAll.category";
            }
        } catch (Exception e) {
            modelMap.addAttribute("category_msg", "session 信息错误");
            log.error(String.valueOf(e));
            return "redirect:findAll.category";
        }
    }

    @RequestMapping("/back/addRoot.category")
    public String addRootCategory(Category category) {
        service.addRootCategory(category);
        return "redirect:findAll.category";
    }

    @RequestMapping("/back/findToTree.category")
    @ResponseBody
    public List<Category> findToTree() {
        return service.findToTree(); // category 容器
    }

    @RequestMapping("/back/addChild.category")
    public String addChildCategory(String name, String desc, int pid) {
        service.addChildCategory(name, desc, pid);
        return "redirect:category_list.jsp";
    }

    @RequestMapping("/back/findById.category")
    public String findById(int id, ModelMap map) {
        Category c = service.findById(id);
        map.addAttribute("c", c);
        return "forward:category_addchild.jsp";
    }

    @RequestMapping("/back/modifyById.category")
    public String modifyById(int id, ModelMap map) {
        Category c = service.findById(id);
        map.addAttribute("c", c);
        return "forward:category_modify.jsp";
    }

    @RequestMapping("/back/modifyDesc.category")
    public String modifyCategoryDesc(Category category) {
        service.modifyCategoryDesc(category);
        return "redirect:category_list.jsp";
    }

    @RequestMapping("/back/findThree.category")
    @ResponseBody
    public List<Category> findThree() {

        return service.findThree();
    }

}
