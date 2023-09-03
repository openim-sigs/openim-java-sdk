package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class GroupInfoForSet {
    private String groupID;
    private String groupName;
    private String notification;
    private String introduction;
    private String faceURL;
    private String ex;

    private Integer needVerification;
    private Integer lookMemberInfo;
    private Integer applyMemberFriend;
}
