package org.ccs.openim.api.auth.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForceLogoutReq {
    private Integer platformID;
    private String userID;
}
