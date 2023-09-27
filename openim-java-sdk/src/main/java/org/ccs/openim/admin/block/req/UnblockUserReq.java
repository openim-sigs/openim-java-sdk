package org.ccs.openim.admin.block.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UnblockUserReq {
    @NotEmpty
    private List<String> userIDs;
}
