package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Data
@Accessors(chain = true)
public class Guide {

    @TableId
    private Long guideId;

    private String guideTitle;

    private Date guideDate;

    private String guideLink;

}