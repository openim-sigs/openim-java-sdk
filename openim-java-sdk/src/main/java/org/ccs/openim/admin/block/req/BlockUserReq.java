package org.ccs.openim.admin.block.req;

import lombok.Data;

@Data
public class BlockUserReq {
    private String userID;
    private String reason;
}
