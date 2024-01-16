package org.ccs.openim.account.req;

import lombok.Data;

@Data
public class AddAdminAccountReq {
    private String account;
    private String password;
    private String faceURL;
    private String nickname;
}
