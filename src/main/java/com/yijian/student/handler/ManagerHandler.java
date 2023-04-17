package com.yijian.student.handler;

import com.yijian.student.bean.req.LoginReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.JwtManagerVO;
import com.yijian.student.mapper.ManagerMapper;
import com.yijian.student.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
* 管理员接口
* */

@RestController
@Slf4j
@RequestMapping("/manager")
public class ManagerHandler {
    @Resource
    private ManagerService managerService;
    @PostMapping("/login")
    public Result<JwtManagerVO> login(@RequestBody @Validated LoginReq loginReq)
    {
        log.info("login params:{}",loginReq);
        return managerService.login(loginReq);
    }
    @PostMapping("/login2")
    public Result<JwtManagerVO> login2(@Validated LoginReq loginReq)
    {
        log.info("login2 params:{}",loginReq);
        return managerService.login(loginReq);
    }
}