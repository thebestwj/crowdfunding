package com.wj.funding.admin.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.mapper.adminDOMapper;
import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.model.adminDOExample;
import com.wj.funding.admin.service.AdminService;
import com.wj.funding.admin.utils.MD5Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/15.
 *
 * @author thebestwj
 */
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    adminDOMapper adminDOMapper;

    @Override
    public List<adminDO> getAll() {
        adminDOExample adminDOExample =new adminDOExample();
        return  adminDOMapper.selectByExample(adminDOExample);
    }
    
    @Override
    public adminDO login(String name, String pw) {
        // 根据loginAcct查询数据库
        adminDOExample adminDOExample = new adminDOExample();
        adminDOExample.createCriteria().andLoginacctEqualTo(name);

        // 执行查询
        List<adminDO> list = adminDOMapper.selectByExample(adminDOExample);
        if(list.size()!=1) {
            // 如果查询结果集合无效，则直接返回null
            return null;
        }

        // 获取唯一集合元素
        adminDO admin = list.get(0);

        // 确认admin不为null
        if(admin == null) {

            return null;
        }

        // 比较密码
        String realpw = admin.getUserpswd();
        String pwmd5 = MD5Tool.md5(pw);
        if(pwmd5.equals(realpw)) {
            // 如果两个密码相等那么说明登录能够成功，返回Admin对象
            return admin;
        }
        return null;
    }

    @Override
    @Transactional
    public int addOne(adminDO adminDO) {
        adminDOMapper.insert(adminDO);
        String a = null;
        a.indexOf('c');
        return 0;
    }

    @Override
    public PageInfo<adminDO> keyWordSearch(Integer pageNum, Integer pageSize,String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        keyword = "%" + keyword + "%";
        adminDOExample example = new adminDOExample();
        example.or().andLoginacctLike(keyword);
        example.or().andEmailLike(keyword);
        example.or().andLoginacctLike(keyword);
        List<adminDO> list = adminDOMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

}

