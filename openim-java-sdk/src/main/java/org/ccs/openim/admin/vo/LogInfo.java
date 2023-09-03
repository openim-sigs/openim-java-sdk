package org.ccs.openim.admin.vo;

import lombok.Data;

@Data
public class LogInfo {
    private String userID;
    private Integer platform;
    private String url;
    private Long createTime;
    private String nickname;
    private String logID;
    private String filename;
    private String systemType;
    private String ex;
    private String version;
}
