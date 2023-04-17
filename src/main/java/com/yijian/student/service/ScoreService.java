package com.yijian.student.service;

import com.yijian.student.bean.req.CommonSearchReq;
import com.yijian.student.bean.req.ScoreAddReq;
import com.yijian.student.bean.req.ScoreUpdateReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.ScoreVO;
import com.yijian.student.bean.vo.StudentVO;

import java.util.List;

public interface ScoreService {
    void add(ScoreAddReq addReq);

    Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<ScoreVO> selectById(Long id);

    void updateById(ScoreUpdateReq updateReq);
}
