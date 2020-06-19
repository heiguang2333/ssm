package com.hzit.mapper;

import com.hzit.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> query();

    int updata(User user);
    int delect(@Param("id") int id);


}