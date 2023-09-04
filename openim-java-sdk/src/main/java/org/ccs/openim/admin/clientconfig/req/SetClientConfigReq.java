package org.ccs.openim.admin.clientconfig.req;

import lombok.Data;

import java.util.Map;

@Data
public class SetClientConfigReq {
    private Map<String, String> config;
}
