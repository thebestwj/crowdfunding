package com.wj.funding.admin.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by white_wolf on 2019/10/15.
 *
 * @author thebestwj
 */
@RestController
@Slf4j
public class DefaultController {
    @RequestMapping("/hello")
    String hello(){
        log.warn("test");
        return "hello";
    }
}
