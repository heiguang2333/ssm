package com.hzit.controller;

import com.hzit.model.User;
import com.hzit.req.UserReq;
import com.hzit.resp.*;
import com.hzit.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
@Autowired
    UserService userService;


@RequestMapping("index")
public String showIndex(){
    return "/user";
}


//显示
    @ResponseBody
    @RequestMapping("show")
    public ShowResp  show(){
        ShowResp showResp=new ShowResp();
        showResp.setCode(0);
        showResp.setMsg("成功");
        List<User> list=userService.query();
        if (CollectionUtils.isEmpty(list)){

            return showResp;
        }
List dataList=new ArrayList();
        for(User s:list){
            UserResp userResp=new UserResp();
            userResp.setAccount(s.getAccount());
            userResp.setPassword(s.getPassword());
            userResp.setName(s.getName());
            userResp.setInfo(s.getInfo());
            userResp.setId(s.getId());
           dataList.add(userResp);
        }
        showResp.setData(dataList);
        return showResp;

    }

    //插入
    @ResponseBody
    @RequestMapping("/add")
    public InsertResp add(@RequestBody  UserReq userReq){
    InsertResp insertResp=new InsertResp();
    if (StringUtils.isEmpty(userReq.getName())){
        insertResp.setStatus(-1);
        insertResp.setMsg("不能为空");
        return insertResp;
    }

    User user=new User();
    user.setInfo(userReq.getInfo());
    user.setAccount(userReq.getAccount());
    user.setPassword(userReq.getPassword());
    user.setName(userReq.getName());
    int j=userService.insert(user);
    if (j>0){
        insertResp.setStatus(1);
        insertResp.setMsg("不能为空");
        return insertResp;
    }else{
        insertResp.setStatus(-1);
        insertResp.setMsg("不能为空");
        return insertResp;
    }
    }
//更新
    @ResponseBody
    @RequestMapping("updata")
    public UpdataResp updata(@RequestBody UserReq userReq){
        UpdataResp resp=new UpdataResp();
    if (StringUtils.isEmpty(userReq.getName())){
        resp.setStatus(0);
        resp.setMsg("更新失败");
        return  resp;
    }

    User user=new User();
    user.setName(userReq.getName());
    user.setPassword(userReq.getPassword());
    user.setAccount(userReq.getAccount());
    user.setInfo(userReq.getInfo());
    user.setId(userReq.getId());
    logger.info("获取到的id"+userReq.getId());
    int j=userService.updata(user);
    if(j>0){
        resp.setStatus(1);
        resp.setMsg("更新成功");
        resp.setUserReq(userReq);
        return  resp;
    }else{
        resp.setStatus(0);
        resp.setMsg("更新失败");
        return  resp;
    }
    }

//删除
    @ResponseBody
    @RequestMapping("delete/{id}")
    public DelectResp delete(@PathVariable("id") int id){
        DelectResp delectResp=new DelectResp();
    int i=userService.delect(id);
    if(i>0){

        delectResp.setStatus(1);
        delectResp.setMsg("删除成功");
        return  delectResp;
    }else {
        delectResp.setStatus(0);
        delectResp.setMsg("删除成功");
        return  delectResp;
    }

    }





}
