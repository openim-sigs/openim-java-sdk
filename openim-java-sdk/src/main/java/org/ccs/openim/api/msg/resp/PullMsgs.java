package org.ccs.openim.api.msg.resp;

import lombok.Data;
import org.ccs.openim.api.msg.vo.MsgData;

import java.util.List;

@Data
public class PullMsgs {
    private List<MsgData> Msgs;
    private Boolean isEnd;

}
