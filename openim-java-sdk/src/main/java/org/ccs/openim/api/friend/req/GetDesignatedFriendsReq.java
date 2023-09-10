package org.ccs.openim.api.friend.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetDesignatedFriendsReq {
    @NotNull
    private String ownerUserID;
    @NotEmpty
    private List<String> friendUserIDs;
}
