package com.hzit.service;

import com.hzit.model.User;
import com.hzit.resp.ShowResp;

import java.util.List;

public interface UserService {
    List<User> query();

    int insert(User record);
    int updata(User user);
    int delect(int id);
}
