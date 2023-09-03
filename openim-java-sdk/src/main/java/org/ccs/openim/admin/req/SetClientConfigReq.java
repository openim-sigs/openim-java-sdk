package org.ccs.openim.admin.req;

import lombok.Data;

import java.util.Map;

@Data
public class SetClientConfigReq {
    private Map<String, String> config;
}
