package org.ccs.openim.admin.defaultUser.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelDefaultFriendReq {
    @NotEmpty
    private List<String> userIDs;
}
