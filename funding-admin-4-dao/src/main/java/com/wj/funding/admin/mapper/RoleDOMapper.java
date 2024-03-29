package com.wj.funding.admin.mapper;

import com.wj.funding.admin.model.RoleDO;
import com.wj.funding.admin.model.RoleDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleDOMapper {
    long countByExample(RoleDOExample example);

    int deleteByExample(RoleDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    List<RoleDO> selectByExample(RoleDOExample example);

    RoleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    List<RoleDO> selectAssignedRoleList(Integer id);

    List<RoleDO> selectUnAssignedRoleList(Integer id);

    void deleteOldAdminRelationship(Integer adminId);

    void insertNewAdminRelationship( @Param("adminId")Integer adminId, @Param("roleIdList") List<Integer> roleIdList);
}