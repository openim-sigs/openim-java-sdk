package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class AddBlackReq {
    private String ownerUserID;
    private String blackUserID;
}
