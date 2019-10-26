package com.wj.funding.admin.service.imp;

import com.wj.funding.admin.mapper.MenuDOMapper;
import com.wj.funding.admin.model.MenuDO;
import com.wj.funding.admin.model.MenuDOExample;
import com.wj.funding.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/26.
 *
 * @author thebestwj
 */
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    MenuDOMapper menuDOMapper;


    @Override
    public List<MenuDO> getAll() {
        return menuDOMapper.selectByExample(new MenuDOExample());
    }

    @Override
    public void addMenu(MenuDO menu) {
        menuDOMapper.insert(menu);
    }

    @Override
    public void updateMenu(MenuDO menu) {
        menuDOMapper.updateByPrimaryKey(menu);
    }

    @Override
    public MenuDO getMenuById(Integer id) {
        return menuDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Integer id) {
        menuDOMapper.deleteByPrimaryKey(id);
    }
}
