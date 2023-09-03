package org.ccs.openim.api.third.resp;

import lombok.Data;

@Data
public class UploadInfo {
    private String uploadID;
    private Long partSize;
    private AuthSignParts sign;
    private Long expireTime;
}
