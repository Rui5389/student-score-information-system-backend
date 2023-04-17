package com.yijian.student.bean.req;

import com.yijian.student.bean.constants.Constants;
import lombok.Data;

@Data
public class CommonSearchReq {
    private Integer PageNow = Constants.DEFAULT_PAGE_NOW;
    private Integer PageSize = Constants.DEFAULT_PAGE_SIZE;
    private String searchWord;

    public Integer getPageNow() {
        return PageNow;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public String getSearchWord() {
        return searchWord;
    }
}
