package com.groupa15.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.entity.Guide;
import com.groupa15.entity.vo.GuideTypeVO;
import com.groupa15.entity.vo.GuideVO;
import com.groupa15.service.GuideService;
import com.groupa15.mapper.GuideMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Service
public class GuideServiceImpl extends ServiceImpl<GuideMapper, Guide> implements GuideService{

    @Autowired
    GuideMapper guideMapper;

    @Override
    public List<GuideVO> getGuideOfType(Long typeId) {
        return guideMapper.selectGuideVoOfType(typeId);
    }

    @Override
    public List<GuideTypeVO> getGuideType() {
        return guideMapper.selectGuideTypeVo();
    }

    @Override
    public GuideTypeVO getGuideTypeById(Long typeId) {
        return guideMapper.selectGuideTypeVoById(typeId);
    }

}




