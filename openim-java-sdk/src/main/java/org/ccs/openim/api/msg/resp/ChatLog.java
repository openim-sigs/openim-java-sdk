package org.ccs.openim.api.msg.resp;

import lombok.Data;

@Data
public class ChatLog {
    private String serverMsgID;
    private String clientMsgID;
    /**
     * 发送者ID
     */
    private String sendID;
    /**
     * 接收者ID
     */
    private String recvID;
    private String groupID;
    private String recvNickname;
    private Integer senderPlatformID;
    private String senderNickname;
    private String senderFaceURL;
    private String groupName;
    private Integer sessionType;
    private Integer msgFrom;
    private Integer contentType;
    private String content;
    private Integer status;
    private Long sendTime;
    private Long createTime;
    private String ex;
    private String groupFaceURL;
    private Integer groupMemberCount;
    private Long seq;
    private String groupOwner;
    private Integer groupType;
}
