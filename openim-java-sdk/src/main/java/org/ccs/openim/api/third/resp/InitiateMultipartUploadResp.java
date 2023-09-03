package org.ccs.openim.api.third.resp;

import lombok.Data;

@Data
public class InitiateMultipartUploadResp {
    private String url;
    private UploadInfo upload;
}
