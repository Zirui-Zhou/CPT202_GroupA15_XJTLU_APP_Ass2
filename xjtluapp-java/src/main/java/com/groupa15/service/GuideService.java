package com.groupa15.service;

import com.groupa15.entity.Guide;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.entity.vo.GuideTypeVO;
import com.groupa15.entity.vo.GuideVO;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

public interface GuideService extends IService<Guide> {

    List<GuideVO> getGuideOfType(Long typeId);

    List<GuideTypeVO> getGuideType(String lang);

    GuideTypeVO getGuideTypeById(Long typeId, String lang);
}
