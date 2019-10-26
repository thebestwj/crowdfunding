package com.wj.funding.admin.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.funding.admin.mapper.RoleDOMapper;
import com.wj.funding.admin.model.RoleDO;
import com.wj.funding.admin.model.RoleDOExample;
import com.wj.funding.admin.service.RoleService;
import com.wj.funding.admin.utils.UtilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by white_wolf on 2019/10/22.
 *
 * @author thebestwj
 */
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleDOMapper roleDOMapper;

    @Override
    public PageInfo<RoleDO> keyWordSearch(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        keyword = "%" + keyword + "%";
        RoleDOExample example = new RoleDOExample();
        example.or().andNameLike(keyword);
        List<RoleDO> list = roleDOMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public void batchRemove(List<Integer> roleArr) {
        RoleDOExample roleDOExample=new RoleDOExample();
        roleDOExample.createCriteria().andIdIn(roleArr);
        roleDOMapper.deleteByExample(roleDOExample);
    }


    @Override
    public List<RoleDO> getRoleListByIdList(List<Integer> roleIdList) {
        RoleDOExample roleDOExample = new RoleDOExample();
        roleDOExample.createCriteria().andIdIn(roleIdList);
        return roleDOMapper.selectByExample(roleDOExample);
    }

    @Override
    public void updateRole(RoleDO role) {
        roleDOMapper.updateByPrimaryKey(role);
    }

    @Override
    public void addRole(RoleDO role) {
        roleDOMapper.insert(role);
    }

    @Override
    public List<RoleDO> getAssignedRoleList(Integer adminId) {
        return roleDOMapper.selectAssignedRoleList(adminId);
    }

    @Override
    public List<RoleDO> getUnAssignedRoleList(Integer adminId) {
        return roleDOMapper.selectUnAssignedRoleList(adminId);
    }

    @Override
    public void updateRelationship(Integer adminId, List<Integer> roleIdList) {
        // 1.删除全部旧数据
        roleDOMapper.deleteOldAdminRelationship(adminId);

        // 2.保存全部新数据
        if(UtilTools.collectionEffective(roleIdList)) {
            roleDOMapper.insertNewAdminRelationship(adminId, roleIdList);
            System.out.println(roleIdList.toString());
        }

    }
}
