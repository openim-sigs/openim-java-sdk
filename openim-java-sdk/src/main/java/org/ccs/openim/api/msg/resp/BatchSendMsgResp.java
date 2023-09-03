package org.ccs.openim.api.msg.resp;

import lombok.Data;

import java.util.List;

@Data
public class BatchSendMsgResp {
    private List<SingleReturnResult> results;
    private List<String> failedUserIDs;
}
