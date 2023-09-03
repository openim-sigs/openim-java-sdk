package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

import java.util.List;

@Data
public class AddUserIPLimitLoginReq {
    private List<UserIPLimitLogin> limits;
}
