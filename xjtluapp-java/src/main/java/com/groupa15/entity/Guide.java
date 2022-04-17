package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Data
public class Guide implements Serializable {

    @TableId
    private Long guideId;

    private String guideTitle;

    private Date guideDate;

    private String guideLink;

}