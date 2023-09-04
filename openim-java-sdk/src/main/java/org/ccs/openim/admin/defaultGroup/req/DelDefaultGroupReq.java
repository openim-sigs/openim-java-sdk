package org.ccs.openim.admin.defaultGroup.req;

import lombok.Data;

import java.util.List;

@Data
public class DelDefaultGroupReq {
    private List<String> groupIDs;
}
