package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class GroupInfo {
    private String groupID;
    private String groupName;
    private String notification;
    private String introduction;
    private String faceURL;
    private String ownerUserID;
    private Long createTime;
    private Integer memberCount;
    private String ex;
    private String status;
    private String creatorUserID;
    private Integer groupType;
    private Integer needVerification;
    private Integer lookMemberInfo;
    private Integer applyMemberFriend;
    private Long notificationUpdateTime;
    private String notificationUserID;
}
