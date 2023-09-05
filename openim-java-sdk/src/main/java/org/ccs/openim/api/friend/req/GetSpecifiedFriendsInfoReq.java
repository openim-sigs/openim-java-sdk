package org.ccs.openim.api.friend.req;

import lombok.Data;

import java.util.List;

@Data
public class GetSpecifiedFriendsInfoReq {
    private String ownerUserID;
    private List<String> userIDList;
}
