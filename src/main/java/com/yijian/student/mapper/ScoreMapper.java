package com.yijian.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yijian.student.bean.entity.ScoreDO;
import com.yijian.student.bean.req.CommonSearchReq;
import com.yijian.student.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreMapper extends BaseMapper<ScoreDO> {
    List<ScoreVO> queryList(CommonSearchReq searchReq);
}
