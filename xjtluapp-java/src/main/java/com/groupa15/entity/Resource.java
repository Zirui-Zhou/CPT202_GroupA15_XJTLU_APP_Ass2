package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@Data
@Accessors(chain = true)
public class Resource {

    @TableId
    private Long resourceId;

    private String resourceName;

    private String resourceImage;

    private String resourcePath;

    private LocalDateTime createTime;

}
