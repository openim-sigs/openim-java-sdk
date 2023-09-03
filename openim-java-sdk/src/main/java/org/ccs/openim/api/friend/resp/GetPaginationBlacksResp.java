package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetPaginationBlacksResp {
    private List<BlackInfo> blacks;
    private Integer total;
}
