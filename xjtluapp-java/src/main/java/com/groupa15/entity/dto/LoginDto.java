package com.groupa15.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "The username cannot be empty")
    private String username;

    @NotBlank(message = "The password cannot be empty")
    private String password;

}
