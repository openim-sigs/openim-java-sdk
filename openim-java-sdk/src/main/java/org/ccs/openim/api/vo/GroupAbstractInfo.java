package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class GroupAbstractInfo {
    private String groupID;
    private Integer groupMemberNumber;
    private Long groupMemberListHash;
}
