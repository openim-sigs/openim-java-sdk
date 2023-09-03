package org.ccs.openim.api.msg.resp;

import lombok.Data;

import java.util.Map;

@Data
public class GetMaxSeqResp {
    private Map<String, Long> maxSeqs;
    private Map<String, Long> minSeqs;
}
