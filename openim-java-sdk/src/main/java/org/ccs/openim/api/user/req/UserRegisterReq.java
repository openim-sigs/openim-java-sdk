package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

import java.util.List;

@Data
public class UserRegisterReq {
    private String secret;
    private List<UserInfo> users;
}
