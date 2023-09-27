package org.ccs.openim.api.friend.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetFriendRemarkReq {
    @NotNull
    private String ownerUserID;
    @NotNull
    private String friendUserID;
    private String remark;
}
