package org.ccs.openim.admin.clientconfig.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class DelClientConfigReq {
    @NotEmpty
    private List<String> keys;
}
