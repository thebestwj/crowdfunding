package com.wj.funding.admin.service;

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
}
