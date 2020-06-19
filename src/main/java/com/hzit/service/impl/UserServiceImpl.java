package com.hzit.service.impl;

import com.hzit.mapper.UserMapper;
import com.hzit.model.User;
import com.hzit.req.UserReq;
import com.hzit.resp.ShowResp;
import com.hzit.resp.UserResp;
import com.hzit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List query() {
        List list=userMapper.query();

        return list;
    }

    @Override
    public int insert(User record) {


      int i= userMapper.insert(record);
        return i;

    }

    @Override
    public int updata(User user) {
        int i=userMapper.updata(user);
        return i;
    }

    @Override
    public int delect(int id) {
        int i=userMapper.delect(id);
        return i;
    }
}
