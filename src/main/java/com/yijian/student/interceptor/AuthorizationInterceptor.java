package com.yijian.student.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import com.yijian.student.bean.constants.Constants;
import com.yijian.student.bean.dto.JwtManagerDTO;
import com.yijian.student.bean.enums.CodeEnum;
import com.yijian.student.bean.res.Result;
import com.yijian.student.context.ManagerContext;
import com.yijian.student.util.JwtUtil;
import com.yijian.student.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthorizationInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // /student/selectById
        log.info("请求路径：{}",request.getServletPath());
        /*
        * axios对非简单的请求(比如：Content-Type：application/json)有时会通过options请求来判断服务是否支持跨域
        * */
        String method = request.getMethod();
        if(HttpMethod.OPTIONS.matches(method))
        {
            //去执行剩下的filter
            return true;
        }
        //获取token
        String tokenToVerify = StringUtils.firstNonBlank(request.getHeader(HttpHeaders.AUTHORIZATION),request.getParameter(Constants.USER_TOKEN_KEY));
        if(StringUtils.isBlank(tokenToVerify))
        {
            //响应失败
            ResponseUtil.respAppJson(response, Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        //校验token
        Result<DecodedJWT> verifyResult = JwtUtil.verify(tokenToVerify);
        if(verifyResult.isFailed())
        {
            //响应失败
            ResponseUtil.respAppJson(response, Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        //从获取的token中还原对象
        JwtManagerDTO jwtManagerDTO = JwtUtil.parse(verifyResult.getData(),JwtManagerDTO.class);
        if(jwtManagerDTO == null)
        {
            //响应失败
            ResponseUtil.respAppJson(response, Result.buildFailure(CodeEnum.AUTH_ERR));
            return false;
        }
        ManagerContext.set(jwtManagerDTO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ManagerContext.remove();
    }
}
