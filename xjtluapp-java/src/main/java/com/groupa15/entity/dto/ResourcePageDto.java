package com.groupa15.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@Data
public class ResourcePageDto implements Serializable {

    private int current;

    private int size;

    private List<Integer> tagList;

}
