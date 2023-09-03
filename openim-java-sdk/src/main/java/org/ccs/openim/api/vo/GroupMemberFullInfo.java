package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class GroupMemberFullInfo {
    private String groupID;
    private String userID;
    private Integer roleLevel;
    private Long joinTime;
    private String nickname;
    private String faceURL;
    private Integer appMangerLevel;
    private Integer joinSource;
    private String operatorUserID;
    private String ex;
    private Long muteEndTime;
    private String inviterUserID;
}
