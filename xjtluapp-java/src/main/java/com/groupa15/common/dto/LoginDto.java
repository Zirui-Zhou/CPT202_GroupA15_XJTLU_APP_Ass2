package com.groupa15.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "The dto username cannot be empty")
    private String username;

    @NotBlank(message = "The dto password cannot be empty")
    private String password;

}
