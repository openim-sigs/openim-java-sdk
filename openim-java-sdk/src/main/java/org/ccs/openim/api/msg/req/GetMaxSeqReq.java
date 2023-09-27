package org.ccs.openim.api.msg.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class GetMaxSeqReq {
    @NotNull
    private String userID;
}
