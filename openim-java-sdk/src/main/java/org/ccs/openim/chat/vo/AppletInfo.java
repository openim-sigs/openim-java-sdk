package org.ccs.openim.chat.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;



/**
 * @author chenjh
 */
@Data
public class AppletInfo {
    private String id;
    @NotNull
    private String name;
    private String appID;
    private String icon;
    private String url;
    private String md5;
    private Long size;
    private String version;
    private Integer priority;
    private Integer status;
    private Long createTime;

}
