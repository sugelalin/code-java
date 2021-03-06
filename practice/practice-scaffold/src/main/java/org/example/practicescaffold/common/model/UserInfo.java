package org.example.practicescaffold.common.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String addr;
}
