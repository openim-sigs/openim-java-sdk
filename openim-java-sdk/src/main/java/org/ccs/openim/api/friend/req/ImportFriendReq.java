package org.ccs.openim.api.friend.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportFriendReq {
    @NotNull
    private String ownerUserID;
    @NotEmpty
    private List<String> friendUserIDs;
}
