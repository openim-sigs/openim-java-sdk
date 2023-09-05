package org.ccs.openim.admin.req;

import lombok.Data;

@Data
public class AdminLoginReq {
    private String account;
    private String password;
}
