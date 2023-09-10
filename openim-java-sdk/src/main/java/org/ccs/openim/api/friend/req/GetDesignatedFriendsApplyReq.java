package org.ccs.openim.api.friend.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDesignatedFriendsApplyReq {
    @NotNull
    private String fromUserID;
    @NotNull
    private String toUserID;
}
