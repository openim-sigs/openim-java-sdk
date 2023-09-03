package org.ccs.openim.api.statistics.resp;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GetActiveGroupResp {
    private Long msgCount;
    private Long groupCount;
    private Map<String, Long> dateCount;
    private List<ActiveGroup> groups;
}
