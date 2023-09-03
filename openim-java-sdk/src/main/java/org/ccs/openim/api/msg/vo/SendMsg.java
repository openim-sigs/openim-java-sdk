package org.ccs.openim.api.msg.vo;

import lombok.Data;

import java.util.Map;

@Data
public class SendMsg {
    private String sendID;
    private String groupID;
    private String senderNickname;
    private String senderFaceURL;
    private Integer senderPlatformID;
    private Map<String, Object> content;
    private Integer contentType;
    private Integer sessionType;
    private boolean isOnlineOnly;
    private boolean notOfflinePush;
    private OfflinePushInfo offlinePushInfo;
}
