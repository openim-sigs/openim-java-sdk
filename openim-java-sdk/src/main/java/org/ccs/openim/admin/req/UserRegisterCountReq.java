package org.ccs.openim.admin.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterCountReq {
    private Long start;
    private Long end;
}
