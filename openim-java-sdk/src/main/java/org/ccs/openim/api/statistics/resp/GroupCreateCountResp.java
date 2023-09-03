package org.ccs.openim.api.statistics.resp;

import lombok.Data;

import java.util.Map;

@Data
public class GroupCreateCountResp {
    private Long total;
    private Long before;
    private Map<String, Long> count;
}
