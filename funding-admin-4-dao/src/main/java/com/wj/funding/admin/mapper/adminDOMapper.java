package com.wj.funding.admin.mapper;

import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.model.adminDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface adminDOMapper {
    long countByExample(adminDOExample example);

    int deleteByExample(adminDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(adminDO record);

    int insertSelective(adminDO record);

    List<adminDO> selectByExample(adminDOExample example);

    adminDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") adminDO record, @Param("example") adminDOExample example);

    int updateByExample(@Param("record") adminDO record, @Param("example") adminDOExample example);

    int updateByPrimaryKeySelective(adminDO record);

    int updateByPrimaryKey(adminDO record);
}