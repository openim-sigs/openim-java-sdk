package org.ccs.openim.api.msg.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MsgData {
    /**
     * 发送者ID
     */
    private String sendID;
    /**
     * 接收者ID
     */
    private String recvID;
    private String groupID;
    private String clientMsgID;
    private String serverMsgID;
    private Integer senderPlatformID;
    private String senderNickname;
    private String senderFaceURL;
    private Integer sessionType;
    private Integer msgFrom;
    private Integer contentType;
    private Byte[] content;
    private Long seq;
    private Long sendTime;
    private Long createTime;
    private Integer status;
    private Boolean isRead;
    private Map<String, Boolean> options;
    private OfflinePushInfo offlinePushInfo;
    private List<String> atUserIDList;
    private String attachedInfo;
    private String ex;
}
