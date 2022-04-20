package com.groupa15.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.groupa15.common.dto.ResourcePageDto;
import com.groupa15.entity.Resource;
import com.groupa15.entity.vo.ResourceScreenshotVO;
import com.groupa15.entity.vo.ResourceTagListVO;
import com.groupa15.entity.vo.ResourceTagVO;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

public interface ResourceService extends IService<Resource> {

    List<ResourceScreenshotVO> getResourcePage(ResourcePageDto resourcePageDto);

    List<ResourceScreenshotVO> getResourcePageOfTags(ResourcePageDto resourcePageDto);

    List<ResourceTagListVO> getAllResourceTags(String lang);
}
