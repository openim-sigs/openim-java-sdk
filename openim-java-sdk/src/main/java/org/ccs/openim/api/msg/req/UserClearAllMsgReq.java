package org.ccs.openim.api.msg.req;

import lombok.Data;

@Data
public class UserClearAllMsgReq {
    private String userID;
    private DeleteSyncOpt deleteSyncOpt;
}
