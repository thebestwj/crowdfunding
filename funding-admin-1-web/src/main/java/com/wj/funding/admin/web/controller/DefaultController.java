package com.wj.funding.admin.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;

/**
 * Created by white_wolf on 2019/10/15.
 *
 * @author thebestwj
 */
@Controller
@Slf4j
public class DefaultController {
    @RequestMapping("/hello")
    ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("msg","hahaha");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/t")
    String test(){
        throw new RuntimeException("an runtime exception");
    }
}
