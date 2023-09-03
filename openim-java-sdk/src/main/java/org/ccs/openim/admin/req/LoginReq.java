package org.ccs.openim.admin.req;

import lombok.Data;

@Data
public class LoginReq {
    private String account;
    private String password;
}
