package org.ccs.openim.api.user.req;


import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

@Data
public class UpdateUserInfoReq {
    private UserInfo userInfo;
}
