package com.wj.funding.admin.web.controller;

import com.wj.funding.admin.model.MenuDO;
import com.wj.funding.admin.result.ResultEntity;
import com.wj.funding.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by white_wolf on 2019/10/26.
 *
 * @author thebestwj
 */

@RestController
@RequestMapping("/menu/")
public class MenuHandler {

    @Autowired
    MenuService menuService;

    @RequestMapping("get/whole/tree")
    public ResultEntity<MenuDO> getWholeTree() {

        // 1.查询所有的树形节点用于组装
        List<MenuDO> menuList = menuService.getAll();
        // 2.将List<Menu>转换为Map<Menu的id,Menu>
        Map<Integer,MenuDO> menuMap = new HashMap<>();

        for (MenuDO menu : menuList) {
            Integer id = menu.getId();
            menuMap.put(id, menu);
        }
        // 3.声明变量用于存储根节点对象
        MenuDO rootNode = null;
        // 4.遍历List<Menu>
        for (MenuDO menu : menuList) {
            // 5.获取当前Menu对象的pid属性
            Integer pid = menu.getPid();
            // 6.判断pid是否为null
            if(pid == null) {
                // 7.如果pid为null，说明当前节点是根节点，所以赋值
                rootNode = menu;
                // 8.根节点没有父节点，所以不必找父节点组装，本次for循环停止执行，继续执行下一次循环
                continue ;
            }
            // 9.既然pid不为null，那么我们根据这个pid查找当前节点的父节点。
            MenuDO father = menuMap.get(pid);
        // 10.组装：将menu添加到maybeFather的子节点集合中
        father.getChildren().add(menu);
    }

        return ResultEntity.successWithData(rootNode);
    }

    @RequestMapping("add")
    public ResultEntity<String> saveMenu(MenuDO menu) {
        menuService.addMenu(menu);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("update")
    public ResultEntity<String> updateMenu(MenuDO menu) {
        menuService.updateMenu(menu);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("{id}")
    public  ResultEntity<MenuDO> getById(@PathVariable  Integer id){
        return ResultEntity.successWithData(menuService.getMenuById(id));
    }

    @RequestMapping("delete/{id}")
    public  ResultEntity<String> deleteById(@PathVariable Integer id){
        menuService.deleteById(id);
        return ResultEntity.successWithoutData();
    }
}
