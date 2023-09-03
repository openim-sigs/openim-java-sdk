package org.ccs.openim.api.friend.resp;

import lombok.Data;

@Data
public class FriendRequest {
    private String fromUserID;
    private String fromNickname;
    private String fromFaceURL;

    private String toUserID;
    private String toNickname;
    private String toFaceURL;

    private Integer handleResult;
    private String reqMsg;

    private Long createTime;
    private String handlerUserID;
    private String handleMsg;

    private Long handleTime;
    private String ex;
}
