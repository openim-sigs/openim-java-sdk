package org.ccs.openim.admin.req;

import lombok.Data;

import java.util.List;

@Data
public class DelAppletReq {
    private List<String> appletIds;
}
