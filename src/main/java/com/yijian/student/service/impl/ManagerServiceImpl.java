package com.yijian.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yijian.student.bean.dto.JwtManagerDTO;
import com.yijian.student.bean.entity.ManagerDO;
import com.yijian.student.bean.req.LoginReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.JwtManagerVO;
import com.yijian.student.mapper.ManagerMapper;
import com.yijian.student.service.ManagerService;
import com.yijian.student.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Result<JwtManagerVO> login(LoginReq loginReq) {
        //查询用户是否存在
        LambdaQueryWrapper<ManagerDO> qw = new LambdaQueryWrapper<>();
        qw.eq(ManagerDO::getUserName,loginReq.getUserName()).eq(ManagerDO::getPwd,loginReq.getPwd());
        ManagerDO managerDO = managerMapper.selectOne(qw);
        log.info("result:{}", JSON.toJSONString(managerDO));
        if(managerDO == null)
        {
            return Result.buildFailure("用户名或密码不正确");
        }
        JwtManagerVO vo = generateToken(managerDO);
        log.info("result:{}",vo);
        return Result.buildSuccess(vo);
    }

    private JwtManagerVO generateToken(ManagerDO managerDO) {
        JwtManagerDTO jwtManagerDTO = new JwtManagerDTO();
        BeanUtils.copyProperties(managerDO,jwtManagerDTO);
        String token = JwtUtil.getToken(jwtManagerDTO);
        //返回给前端 token + 用户信息
        JwtManagerVO vo = new JwtManagerVO();
        BeanUtils.copyProperties(jwtManagerDTO, vo);
        vo.setToken(token);
        return vo;
    }
}
