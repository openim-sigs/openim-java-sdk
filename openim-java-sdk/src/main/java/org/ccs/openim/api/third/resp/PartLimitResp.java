package org.ccs.openim.api.third.resp;

import lombok.Data;

@Data
public class PartLimitResp {
    private Long minPartSize;
    private Long maxPartSize;
    private Integer maxNumSize;
}
