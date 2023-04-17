package com.yijian.student.service;

import com.yijian.student.bean.req.LoginReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.JwtManagerVO;

public interface ManagerService {

    Result<JwtManagerVO> login(LoginReq loginReq);
}
