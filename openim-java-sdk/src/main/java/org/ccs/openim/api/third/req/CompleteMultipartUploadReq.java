package org.ccs.openim.api.third.req;

import lombok.Data;

import java.util.List;

@Data
public class CompleteMultipartUploadReq {
    private String uploadID;
    private List<String> parts;
    private String name;
    private String contentType;
    private String cause;
}
