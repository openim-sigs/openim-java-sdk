package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfoWithEx;

@Data
public class UpdateUserInfoExReq {
    private UserInfoWithEx userInfo;
}
