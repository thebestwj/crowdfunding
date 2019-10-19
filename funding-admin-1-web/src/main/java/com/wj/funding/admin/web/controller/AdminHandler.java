package com.wj.funding.admin.web.controller;

import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.service.AdminService;
import com.wj.funding.admin.utils.AdminConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by white_wolf on 2019/10/16.
 *
 * @author thebestwj
 */
@Controller
@Slf4j
@Transactional
public class AdminHandler {
    @Autowired
    AdminService adminService;

    @RequestMapping("admin/query/for/search")
    public String queryForSearch(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String keyword,
            Model m){
        PageInfo<adminDO> pageInfo = adminService.keyWordSearch(pageNum,pageSize,keyword);
        m.addAttribute(AdminConst.ATT_NAME_PAGE_INFO,pageInfo);

        return "admin-page";
    }

    @RequestMapping("/admin/get/all")
    public String getAll(Model model) {
        List<adminDO> list = adminService.getAll();
        model.addAttribute("list", list);
        return "admin-target";
    }

    @PostMapping("/admin/do/login")
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

    @RequestMapping("admin/main")
    String adminmain(){
        return "admin-main";
    }

    @RequestMapping("/admin/logout")
    String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index.html";
    }

}
