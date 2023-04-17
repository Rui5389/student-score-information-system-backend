package com.yijian.student.bean.req;

import javax.validation.constraints.NotBlank;

/*
* 登录请求参数
* */
public class LoginReq {
    /*
     *  用户名
     * */
    @NotBlank
    private String userName;
    /*
     *  密码
     * */
    @NotBlank
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }
}
