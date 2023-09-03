package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class RespondFriendApplyReq {
    /**
     * 主动发起的申请者
     */
    private String fromUserID;
    /**
     * 被动添加者
     */
    private String toUserID;
    private Integer handleResult;
    private String handleMsg;
}
