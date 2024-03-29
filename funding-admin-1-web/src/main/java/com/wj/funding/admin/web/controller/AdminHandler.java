package com.wj.funding.admin.web.controller;

import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.result.ResultEntity;
import com.wj.funding.admin.service.AdminService;
import com.wj.funding.admin.utils.AdminConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by white_wolf on 2019/10/16.
 *
 * @author thebestwj
 */
@Controller
@Slf4j
@Transactional
@RequestMapping("/admin/")
public class AdminHandler {
    @Autowired
    AdminService adminService;

    @GetMapping("edit/{id}")
    public ModelAndView editAdmin(@PathVariable(value = "id") Integer id){
        try{
            adminDO adminDO = adminService.getAdminById(id);
            ModelAndView mav = new ModelAndView();
            mav.addObject("user",adminDO);
            mav.setViewName("admin-edit");
            return  mav;
        }catch (Exception e){
            return null;
        }
    }


    @PostMapping("update")
    public String update(@Valid adminDO adminDO, Errors errors){
        if (errors.hasErrors()){

        }
        System.out.println(adminDO.getLoginacct());
        System.out.println(adminDO.getUsername());
        System.out.println(adminDO.getUserpswd());
        System.out.println(adminDO.getEmail());
        adminService.updateAdmin(adminDO);
        return "redirect:/admin/query/for/search";
    }

    @ResponseBody
    @PostMapping("batch/remove")
    public ResultEntity batchRemove(@RequestBody List<Integer> adminArr){

        try {

            adminService.batchRemove(adminArr);
            return ResultEntity.successWithoutData();
        }catch (Exception e){

            return ResultEntity.failed(null,e.getMessage());
        }

    }


    @RequestMapping("query/for/search")
    public String queryForSearch(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String keyword,
            Model m){
        PageInfo<adminDO> pageInfo = adminService.keyWordSearch(pageNum,pageSize,keyword);
        m.addAttribute(AdminConst.ATT_NAME_PAGE_INFO,pageInfo);
        return "admin-page";
    }

    @RequestMapping("get/all")
    public String getAll(Model model) {
        List<adminDO> list = adminService.getAll();
        model.addAttribute("list", list);
        return "admin-target";
    }


    @PostMapping("do/add")
    public String addAdmin(adminDO adminDO){
        try {
            adminService.saveAdmin(adminDO);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                throw new RuntimeException("账号被占用");
            }
        }
        return "redirect:/admin/query/for/search";
    }



    @PostMapping("do/login")
    public String doLogin(
            @RequestParam("loginAcct") String loginAcct,
            @RequestParam("userPswd") String userPswd,
            Model model,
            HttpSession session) {
        log.warn("admin try login");
        // 调用adminService的login方法执行登录业务逻辑，返回查询到的Admin对象
        adminDO admin = adminService.login(loginAcct, userPswd);
        // 判断admin是否为null
        if(admin == null) {
            model.addAttribute(AdminConst.ATT_NAME_MESSAGE, AdminConst.MESSAGE_LOGIN_FAIL);
            return "admin-login";
    }
        session.setAttribute(AdminConst.ATT_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/main";
    }

    @RequestMapping("logout")
    String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index.html";
    }

}
