package org.ccs.openim.admin.clientconfig.resp;

import lombok.Data;

import java.util.Map;

@Data
public class GetClientConfigResp {
    private Map<String, String> config;
}
