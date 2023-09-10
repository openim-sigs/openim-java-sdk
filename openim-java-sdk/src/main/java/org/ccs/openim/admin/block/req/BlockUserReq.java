package org.ccs.openim.admin.block.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BlockUserReq {
    @NotNull
    private String userID;
    private String reason;
}
