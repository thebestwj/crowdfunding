package com.wj.funding.admin.web.controller;

import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/16.
 *
 * @author thebestwj
 */
@Controller
public class AdminHandler {
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/get/all")
    public String getAll(Model model) {

        List<adminDO> list = adminService.getAll();

        model.addAttribute("list", list);

        return "admin-target";
    }

}
