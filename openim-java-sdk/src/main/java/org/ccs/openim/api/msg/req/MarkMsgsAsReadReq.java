package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class MarkMsgsAsReadReq {
    private String conversationID;
    private List<Long> seqs;
    private String userID;

}
