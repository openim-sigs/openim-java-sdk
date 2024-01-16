package org.ccs.openim.account.req;

import lombok.Data;
import org.ccs.openim.chat.account.req.RegisterUserInfo;

@Data
public class AddUserAccountReq {
    private String ip;
    private String deviceID;
    private Integer platform;
    private RegisterUserInfo user;
}
