package org.ccs.openim.admin.resp.defaultUser;

import lombok.Data;

import java.util.List;

@Data
public class SearchDefaultFriendResp {
    private List<DefaultFriendAttribute> users;
    private Integer total;
}
