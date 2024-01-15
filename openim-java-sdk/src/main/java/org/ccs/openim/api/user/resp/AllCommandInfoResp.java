package org.ccs.openim.api.user.resp;

import lombok.Data;

@Data
public class AllCommandInfoResp {
    private Integer type;
    private Long createTime;
    private String uuid;
    private String value;
    private String ex;
}
