package com.wj.funding.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.model.adminDO;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/15.
 *
 * @author thebestwj
 */
public interface AdminService {
    List<adminDO> getAll();
    adminDO login(String name,String pw);
    int addOne(adminDO adminDO);
    PageInfo<adminDO> keyWordSearch(Integer pageNum, Integer pageSize,String keyword);
}
