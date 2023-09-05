package org.ccs.openim.admin.defaultUser.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDefaultFriendReq {
    private List<String> userIDs;
}
