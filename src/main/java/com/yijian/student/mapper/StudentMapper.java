package com.yijian.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yijian.student.bean.entity.StudentDO;
import com.yijian.student.bean.req.CommonSearchReq;
import com.yijian.student.bean.vo.StudentVO;

import java.util.List;

public interface StudentMapper extends BaseMapper<StudentDO> {

    List<StudentVO> queryList(CommonSearchReq searchReq);
}
