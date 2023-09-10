package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TransferGroupOwnerReq {
    @NotNull
    private String groupID;
    @NotNull
    private String oldOwnerUserID;
    @NotNull
    private String newOwnerUserID;
}
