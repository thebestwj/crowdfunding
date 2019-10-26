package com.wj.funding.admin.mapper;

import com.wj.funding.admin.model.MenuDO;
import com.wj.funding.admin.model.MenuDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MenuDOMapper {
    long countByExample(MenuDOExample example);

    int deleteByExample(MenuDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuDO record);

    int insertSelective(MenuDO record);

    List<MenuDO> selectByExample(MenuDOExample example);

    MenuDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuDO record, @Param("example") MenuDOExample example);

    int updateByExample(@Param("record") MenuDO record, @Param("example") MenuDOExample example);

    int updateByPrimaryKeySelective(MenuDO record);

    int updateByPrimaryKey(MenuDO record);
}