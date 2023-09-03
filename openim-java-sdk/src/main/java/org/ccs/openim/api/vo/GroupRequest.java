package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class GroupRequest {
    private PublicUserInfo userInfo;
    private GroupInfo groupInfo;
    private Integer handleResult;
    private String reqMsg;
    private String handleMsg;
    private Long reqTime;
    private String handleUserID;
    private Long handleTime;
    private String ex;
    private Integer joinSource;
    private String inviterUserID;
}
