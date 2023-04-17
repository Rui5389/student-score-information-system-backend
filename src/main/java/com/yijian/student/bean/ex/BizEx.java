package com.yijian.student.bean.ex;

import com.yijian.student.bean.enums.CodeEnum;

public class BizEx extends RuntimeException{
    private Integer code;

    public BizEx(Integer code) {
        this.code = code;
    }

    public BizEx(String message) {
        super(message);
    }

    public BizEx(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BizEx(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
