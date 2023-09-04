package org.ccs.openim.admin.defaultGroup.resp;

import lombok.Data;

import java.util.List;

@Data
public class SearchDefaultGroupResp {
    private Integer total;
    private List<String> groupIDs;
}
