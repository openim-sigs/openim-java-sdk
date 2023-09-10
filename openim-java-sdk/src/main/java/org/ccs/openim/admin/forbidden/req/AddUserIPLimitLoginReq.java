package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AddUserIPLimitLoginReq {
    @NotEmpty
    private List<UserIPLimitLogin> limits;
}
