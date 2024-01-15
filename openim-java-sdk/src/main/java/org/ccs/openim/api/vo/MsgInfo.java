package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class MsgInfo {
    private String serverMsgID;
    private String clientMsgID;
    private Integer sessionType;

    private String sendID;
    private String recvID;
    private String senderName;
    private String faceURL;
    private String groupID;
    private String groupName;
    private String groupFaceURL;
    private Integer groupType;
    private Integer groupMemberCount;
    private Long LatestMsgRecvTime;
    private Integer msgFrom;
    private Integer contentType;
    private String content;
}
