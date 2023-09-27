package org.ccs.openim.api.friend.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class RespondFriendApplyReq {
    /**
     * 主动发起的申请者
     */
    @NotNull
    private String fromUserID;
    /**
     * 被动添加者
     */
    @NotNull
    private String toUserID;
    private Integer handleResult;
    private String handleMsg;
}
