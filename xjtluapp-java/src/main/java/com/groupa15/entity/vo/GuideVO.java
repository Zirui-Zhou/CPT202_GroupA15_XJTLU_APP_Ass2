package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Data
public class GuideVO implements Serializable {

    private Long guideId;

    private String guideTitle;

    private Date guideDate;

    private String guideLink;

}
