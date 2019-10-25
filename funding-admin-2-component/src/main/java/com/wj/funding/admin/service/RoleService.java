package com.wj.funding.admin.service;

import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.model.RoleDO;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/22.
 *
 * @author thebestwj
 */
public interface RoleService {
    PageInfo<RoleDO> keyWordSearch(Integer pageNum, Integer pageSize, String keyword);
    void batchRemove(List<Integer> roleArr);
    List<RoleDO> getRoleListByIdList(List<Integer> roleIdList);
    void updateRole(RoleDO role);
    void addRole(RoleDO role);
}
