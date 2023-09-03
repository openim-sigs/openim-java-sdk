package org.ccs.openim.api.auth.resp;

import lombok.Data;

@Data
public class ParseTokenResp {
    private Integer expireTimeSeconds;

    private String userID;

    private String platform;
}
