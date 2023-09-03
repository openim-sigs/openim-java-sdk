package org.ccs.openim.api.msg.req;

import lombok.Data;

@Data
public class DeleteSyncOpt {
    private Boolean IsSyncSelf;
    private Boolean IsSyncOther;
}
