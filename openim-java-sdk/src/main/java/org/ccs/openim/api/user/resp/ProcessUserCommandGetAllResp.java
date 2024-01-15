package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class ProcessUserCommandGetAllResp {
    private List<AllCommandInfoResp> CommandResp;
}
