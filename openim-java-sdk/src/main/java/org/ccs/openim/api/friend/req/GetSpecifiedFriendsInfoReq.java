package org.ccs.openim.api.friend.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetSpecifiedFriendsInfoReq {
    @NotNull
    private String ownerUserID;
    @NotEmpty
    private List<String> userIDList;
}
