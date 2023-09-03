package org.ccs.openim.api.msg.vo;

import lombok.Data;

@Data
public class OfflinePushInfo {
    private String title;
    private String desc;
    private String ex;
    private String iOSPushSound;
    private Boolean iOSBadgeCount;
    private String signalInfo;
}
