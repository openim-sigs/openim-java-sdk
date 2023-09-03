package org.ccs.openim.api.statistics.resp;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GetActiveUserResp {
    private Long msgCount;
    private Long userCount;
    private Map<String, Long> dateCount;

    private List<ActiveUser> users;

}
