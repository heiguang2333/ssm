package com.hzit.resp;

import com.hzit.req.UserReq;

public class UpdataResp {
    private int status;
    private String msg;
    private UserReq userReq;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserReq getUserReq() {
        return userReq;
    }

    public void setUserReq(UserReq userReq) {
        this.userReq = userReq;
    }
}
