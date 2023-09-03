package org.ccs.openim.admin.forbidden.resp;

import lombok.Data;

@Data
public class IPForbidden {
    private String ip;
    private boolean limitRegister;
    private boolean limitLogin;
    private Long createTime;
}
