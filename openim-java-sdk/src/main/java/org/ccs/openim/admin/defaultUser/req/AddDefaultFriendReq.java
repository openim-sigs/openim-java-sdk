package org.ccs.openim.admin.defaultUser.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDefaultFriendReq {
    @NotEmpty
    private List<String> userIDs;
}
