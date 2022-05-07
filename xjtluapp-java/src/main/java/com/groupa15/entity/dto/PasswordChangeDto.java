package com.groupa15.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/4/18
 */

@Data
public class PasswordChangeDto implements Serializable {

    private String oldPassword;

    private String newPassword;

}
