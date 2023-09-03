package org.ccs.openim.api.third.req;

import lombok.Data;

@Data
public class InitiateMultipartUploadReq {
    private String hash;
    private Long size;
    private Long partSize;
    private Integer maxParts;
    private String cause;
    private String name;
    private String contentType;
}
