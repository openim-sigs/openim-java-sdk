package org.ccs.openim.admin.forbidden.resp;

import lombok.Data;
import org.ccs.openim.chat.vo.UserPublicInfo;

@Data
public class LimitUserLoginIP {
    private String userID;
    private String ip;
    private Long createTime;
    private UserPublicInfo user;
}
