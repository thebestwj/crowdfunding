package com.wj.funding.admin.web.controller;

import com.wj.funding.admin.model.RoleDO;
import com.wj.funding.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/26.
 *
 * @author thebestwj
 */

@Controller
@RequestMapping("/assign/")
public class AssignHandler {

        @Autowired
        private RoleService roleService;

        @RequestMapping("page/{id}")
        public String toAssignRolePage(@PathVariable("id") Integer adminId, Model model) {

            // 1.查询已分配角色
            List<RoleDO> assignedRoleList = roleService.getAssignedRoleList(adminId);

            // 2.查询未分配角色
            List<RoleDO> unAssignedRoleList = roleService.getUnAssignedRoleList(adminId);

            // 3.存入模型
            model.addAttribute("assignedRoleList", assignedRoleList);
            model.addAttribute("unAssignedRoleList", unAssignedRoleList);
            model.addAttribute("adminId",adminId);
            return "assign-role";
        }

        @RequestMapping("role")
        public String doAssignRole(
                // roleIdList不一定每一次都能够提供，没有提供我们也接受
                @RequestParam(value="roleIdList", required = false) List<Integer> roleIdList,
                @RequestParam("adminId") Integer adminId,
                @RequestParam(value = "pageNum" , defaultValue = "1") String pageNum) {

            roleService.updateRelationship(adminId, roleIdList);

            return "redirect:/admin/query/for/search?pageNum="+pageNum;
        }


}
