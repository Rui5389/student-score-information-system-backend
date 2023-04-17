package com.yijian.student.service.impl;

import com.yijian.student.bean.entity.ScoreDO;
import com.yijian.student.bean.entity.StudentDO;
import com.yijian.student.bean.req.CommonSearchReq;
import com.yijian.student.bean.req.ScoreAddReq;
import com.yijian.student.bean.req.ScoreUpdateReq;
import com.yijian.student.bean.req.StudentUpdateReq;
import com.yijian.student.bean.res.Result;
import com.yijian.student.bean.vo.ScoreVO;
import com.yijian.student.bean.vo.StudentVO;
import com.yijian.student.mapper.ScoreMapper;
import com.yijian.student.service.ScoreService;
import com.yijian.student.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ScoreAddReq addReq) {
        ScoreDO entity = new ScoreDO();
        BeanUtils.copyProperties(addReq,entity);
        scoreMapper.insert(entity);
    }

    @Override
    public Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq) {
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<ScoreVO> list= scoreMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        scoreMapper.deleteById(id);
    }

    @Override
    public Result<ScoreVO> selectById(Long id) {
        ScoreDO entity = scoreMapper.selectById(id);
        if(entity == null)
        {
            return Result.buildEmptySuccess();
        }
        ScoreVO vo = new ScoreVO();
        BeanUtils.copyProperties(entity,vo);
        return Result.buildSuccess(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ScoreUpdateReq updateReq) {
        ScoreDO entityToUpdate = new ScoreDO();
        BeanUtils.copyProperties(updateReq,entityToUpdate);
        scoreMapper.updateById(entityToUpdate);
    }
}