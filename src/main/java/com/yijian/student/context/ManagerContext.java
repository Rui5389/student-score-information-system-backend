package com.yijian.student.context;

import com.yijian.student.bean.dto.JwtManagerDTO;

public class ManagerContext {
    private static ThreadLocal<JwtManagerDTO> threadLocal = new ThreadLocal<>();
    public static void set(JwtManagerDTO dto)
    {
        threadLocal.set(dto);
    }
    public static JwtManagerDTO get()
    {
        return threadLocal.get();
    }
    public static void remove()
    {
        threadLocal.remove();
    }
}
