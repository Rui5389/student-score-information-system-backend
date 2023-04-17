package com.yijian.student.service;

import com.yijian.student.bean.req.CommonSearchReq;
import com.yijian.student.bean.req.StudentAddReq;
import com.yijian.student.bean.req.StudentUpdateReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.StudentVO;

import java.util.List;

public interface StudentService {
    void add(StudentAddReq addReq);

    Result<List<StudentVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<StudentVO> selectById(Long id);

    void updateById(StudentUpdateReq updateReq);

    Result<List<StudentVO>> selectAll();
}
