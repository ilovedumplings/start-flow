package com.shi.mybatis.mapper;

import com.shi.mybatis.entity.UserTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTagMapper {

    List<UserTag> selectAll();
}
