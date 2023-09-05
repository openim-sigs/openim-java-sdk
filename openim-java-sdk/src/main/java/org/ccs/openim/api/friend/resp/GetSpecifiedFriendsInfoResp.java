package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetSpecifiedFriendsInfoResp {
    private List<GetSpecifiedFriendsInfoInfo> infos;
}
