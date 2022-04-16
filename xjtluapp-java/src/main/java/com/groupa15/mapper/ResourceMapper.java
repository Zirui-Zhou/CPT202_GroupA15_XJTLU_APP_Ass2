package com.groupa15.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupa15.entity.Article;
import com.groupa15.entity.Resource;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ResourceScreenshotVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    Page<ResourceScreenshotVO> selectResourcePageVo(Page<ResourceScreenshotVO> iPage);

}
