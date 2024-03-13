package org.ccs.openim.api.auth.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserTokenReq {
    private Integer platformID;
    private String userID;
}
