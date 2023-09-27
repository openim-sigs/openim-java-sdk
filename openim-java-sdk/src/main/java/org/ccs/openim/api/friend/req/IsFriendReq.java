package org.ccs.openim.api.friend.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IsFriendReq {
    @NotNull
    private String userID1;
    @NotNull
    private String userID2;
}
