package org.ccs.openim.admin.applet.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class DelAppletReq {
    @NotEmpty
    private List<String> appletIds;
}
