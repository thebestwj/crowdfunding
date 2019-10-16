package com.wj.funding.admin.service.imp;

import com.wj.funding.admin.mapper.adminDOMapper;
import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
