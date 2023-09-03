package org.ccs.openim.api.msg.resp;

import lombok.Data;

import java.util.Map;

@Data
public class PullMessageBySeqsResp {
    private Map<String, PullMsgs> msgs;
    private Map<String, PullMsgs> notificationMsgs;
}
