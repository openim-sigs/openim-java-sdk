package org.ccs.openim.admin.block.req;

import lombok.Data;

import java.util.List;

@Data
public class UnblockUserReq {
    private List<String> userIDs;
}
