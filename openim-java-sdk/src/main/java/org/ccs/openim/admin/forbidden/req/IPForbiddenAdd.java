package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

@Data
public class IPForbiddenAdd {
    private String ip;
    private Boolean limitRegister;
    private Boolean limitLogin;
}
