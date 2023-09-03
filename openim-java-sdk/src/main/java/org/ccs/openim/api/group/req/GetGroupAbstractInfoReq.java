package org.ccs.openim.api.group.req;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupAbstractInfoReq {
    private List<String> groupIDs;
}
