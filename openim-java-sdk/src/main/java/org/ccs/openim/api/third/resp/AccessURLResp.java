package org.ccs.openim.api.third.resp;

import lombok.Data;

@Data
public class AccessURLResp {
    private String url;
    private Long expireTime;
}
