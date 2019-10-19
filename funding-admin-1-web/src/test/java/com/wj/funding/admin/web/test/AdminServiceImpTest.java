package com.wj.funding.admin.web.test;

import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.mapper.adminDOMapper;
import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by white_wolf on 2019/10/19.
 *
 * @author thebestwj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan("com.wj.funding.admin.service")
public class AdminServiceImpTest {

    @Autowired
    AdminService adminService;

    @Autowired
    adminDOMapper adminDOMapper;

    @Test
    public void addOne() {
        adminDO adminDO = new adminDO();
        adminDO = adminDOMapper.selectByPrimaryKey(1);
        adminDO.setLoginacct("hahaha");
        adminDO.setId(null);
        adminService.addOne(adminDO);
    }

    @Test
    public void keywordTest(){
        PageInfo<adminDO> pageInfo = adminService.keyWordSearch(1,10,"4");
        System.out.println(pageInfo.getList().size());
    }
}