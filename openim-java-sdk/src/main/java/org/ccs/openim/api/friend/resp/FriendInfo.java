package org.ccs.openim.api.friend.resp;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

@Data
public class FriendInfo {
    private String ownerUserID;
    private String remark;
    private Long createTime;
    private UserInfo friendUser;
    private Integer addSource;
    private String operatorUserID;
    private String ex;
}
