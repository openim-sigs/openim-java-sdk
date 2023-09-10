package org.ccs.openim.api.msg.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetMaxSeqReq {
    @NotNull
    private String userID;
}
