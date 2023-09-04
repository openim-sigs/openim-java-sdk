package org.ccs.openim.admin.defaultGroup.resp;

import lombok.Data;

import java.util.List;

@Data
public class FindDefaultGroupResp {
    private List<String> groupIDs;
}
