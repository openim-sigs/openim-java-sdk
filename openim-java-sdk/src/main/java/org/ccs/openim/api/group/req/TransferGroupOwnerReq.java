package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class TransferGroupOwnerReq {
    private String groupID;
    private String oldOwnerUserID;
    private String newOwnerUserID;
}
