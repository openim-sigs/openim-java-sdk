package org.ccs.openim.api.msg.resp;

import lombok.Data;

@Data
public class SendMsgResp {
    private String serverMsgID;
    private String clientMsgID;
    private Long sendTime;
}
