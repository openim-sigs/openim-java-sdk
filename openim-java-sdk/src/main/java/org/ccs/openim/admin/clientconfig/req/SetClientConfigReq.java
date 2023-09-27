package org.ccs.openim.admin.clientconfig.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Data
public class SetClientConfigReq {
    @NotNull
    private Map<String, String> config;
}
