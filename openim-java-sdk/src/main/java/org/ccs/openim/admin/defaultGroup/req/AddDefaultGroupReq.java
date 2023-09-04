package org.ccs.openim.admin.defaultGroup.req;

import lombok.Data;

import java.util.List;

@Data
public class AddDefaultGroupReq {
    private List<String> groupIDs;
}
