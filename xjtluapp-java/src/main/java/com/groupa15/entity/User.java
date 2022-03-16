package com.groupa15.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Setter
@Getter
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Entity
@Proxy(lazy = false)
//@Proxy(lazy = false)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "The username cannot be empty")
    private String username;

//    private String avatar;
//
//    @NotBlank(message = "The email cannot be empty")
//    @Email(message = "The email format is not correct")
//    private String email;

    private String password;

//    private Integer status;
//
//    private LocalDateTime created;
//
//    private LocalDateTime lastLogin;
}
