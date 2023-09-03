package org.ccs.openim.api.group.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupsResp {
    private Integer total;
    private List<CMSGroup> groups;
}
