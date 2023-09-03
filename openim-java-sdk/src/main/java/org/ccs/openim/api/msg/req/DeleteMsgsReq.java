package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMsgsReq {
    private String conversationID;
    private List<Long> seqs;
    private String userID;
    private DeleteSyncOpt deleteSyncOpt;

}
