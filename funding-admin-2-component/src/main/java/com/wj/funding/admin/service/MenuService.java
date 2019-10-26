package com.wj.funding.admin.service;

import com.wj.funding.admin.model.MenuDO;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/26.
 *
 * @author thebestwj
 */
public interface MenuService {
    List<MenuDO> getAll();
    void addMenu(MenuDO menu);
    void updateMenu(MenuDO menu);
    MenuDO getMenuById(Integer id);
    void deleteById(Integer id);
}
