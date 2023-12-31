package com.yijian.student.util;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yijian.student.bean.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {
    /*
    *  向前端浏览器写入响应数据
    * */
    public static void respAppJson(HttpServletResponse response, Object obj)
    {
        response.setCharacterEncoding(Constants.UTF_8_NAME);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try(PrintWriter pw = response.getWriter())
        {
            pw.print(JSON.toJSONString(obj));
            pw.flush();
        }catch (IOException e)
        {
            log.error("写到前段异常");
        }
    }
}
