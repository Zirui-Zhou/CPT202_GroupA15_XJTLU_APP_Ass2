package com.groupa15.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupa15.common.dto.ResourcePageDto;
import com.groupa15.entity.Resource;
import com.groupa15.entity.vo.ResourceScreenshotVO;
import com.groupa15.mapper.ResourceMapper;
import com.groupa15.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public List<ResourceScreenshotVO> getResourcePage(ResourcePageDto resourcePageDto) {
        Page<ResourceScreenshotVO> page = new Page<>(resourcePageDto.getCurrent(), resourcePageDto.getSize());
        page = resourceMapper.selectResourcePageVo(page);
        return page.getRecords();
    }

}
