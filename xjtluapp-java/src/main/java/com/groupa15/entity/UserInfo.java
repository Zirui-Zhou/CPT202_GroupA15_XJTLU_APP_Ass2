package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Data
@Accessors(chain = true)
public class UserInfo {

    @TableId
    private Long userId;

    private String realName;

    private Long realId;

    private String major;

    private String semester;

    private String email;

    private String avatar;

}
