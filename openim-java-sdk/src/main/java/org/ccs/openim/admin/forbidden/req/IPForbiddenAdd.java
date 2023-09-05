package org.ccs.openim.admin.forbidden.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPForbiddenAdd {
    private String ip;
    private Boolean limitRegister;
    private Boolean limitLogin;
}
