package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class SetGroupMemberInfo {
    private String groupID;
    private String userID;
    private String nickname;
    private String faceURL;
    private Integer roleLevel;
    private String ex;
}
