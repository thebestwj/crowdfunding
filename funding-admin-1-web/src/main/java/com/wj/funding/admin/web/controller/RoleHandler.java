package com.wj.funding.admin.web.controller;

import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.model.RoleDO;
import com.wj.funding.admin.result.ResultEntity;
import com.wj.funding.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/22.
 *
 * @author thebestwj
 */
@RestController
@RequestMapping("/role/")
public class RoleHandler {

    @Autowired
    RoleService roleService;

    @RequestMapping("search")
    public ResultEntity<PageInfo<RoleDO>> serach(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String keyword
    ) {
        PageInfo<RoleDO> pageInfo = roleService.keyWordSearch(pageNum,pageSize,keyword);
        return ResultEntity.successWithData(pageInfo);
    }

    @PostMapping("get/list/by/id")
    public ResultEntity<List<RoleDO>> getRoleListByIdList(@RequestBody List<Integer> roleIdList) {
        List<RoleDO> roleList = roleService.getRoleListByIdList(roleIdList);
        return ResultEntity.successWithData(roleList);
    }

    @PostMapping("batch/remove")
    public ResultEntity<String> batchRemove(@RequestBody List<Integer> roleIdList) {
        roleService.batchRemove(roleIdList);
        return ResultEntity.successWithoutData();
    }

    @PostMapping("update")
    public ResultEntity<String> updateRole(RoleDO role) {

        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }

    @PostMapping("add")
    public ResultEntity<String> addRole(RoleDO role) {
        roleService.addRole(role);
        return ResultEntity.successWithoutData();
    }
}
