package com.groupa15.mapper;

import com.groupa15.entity.Guide;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupa15.entity.vo.GuideTypeVO;
import com.groupa15.entity.vo.GuideVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Mapper
public interface GuideMapper extends BaseMapper<Guide> {

    List<GuideVO> selectGuideVoOfType(@Param("typeId")Long typeId);

    List<GuideTypeVO> selectGuideTypeVo();

    GuideTypeVO selectGuideTypeVoById(@Param("typeId")Long typeId);

}




