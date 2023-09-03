package org.ccs.openim.api.user.req;

import lombok.Data;

@Data
public class SetGlobalRecvMessageOptReq {
    private String userID;
    private Integer globalRecvMsgOpt;
}
