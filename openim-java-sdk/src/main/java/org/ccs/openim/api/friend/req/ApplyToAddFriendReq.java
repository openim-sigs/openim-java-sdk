package org.ccs.openim.api.friend.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ApplyToAddFriendReq {
    @NotNull
    private String fromUserID;
    @NotNull
    private String toUserID;
    private String reqMsg;
    private String ex;
}
