package org.ccs.openim.api.third.req;

import lombok.Data;

@Data
public class InitiateFormDataReq {
    private String name;
    private Long size;
    private String contentType;
    private String group;
    private Long millisecond;
    private Boolean absolute;
}
