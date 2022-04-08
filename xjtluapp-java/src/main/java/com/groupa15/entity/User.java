package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Qi Xu
 * @date 2022/3/15
 */

@Data
@Accessors(chain = true)
public class User {

    @TableId
    private Long userId;

    private String userName;

    private String password;

    private String salt;

    private LocalDateTime createTime;

    private String avatar;

}
