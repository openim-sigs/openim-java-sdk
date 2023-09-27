package org.ccs.openim.api.user.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AccountCheckReq {
    @NotEmpty
    private List<String> checkUserIDs;
}
