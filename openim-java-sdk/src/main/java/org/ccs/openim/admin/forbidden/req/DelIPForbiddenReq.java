package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

import java.util.List;

@Data
public class DelIPForbiddenReq {
    private List<String> ips;
}
