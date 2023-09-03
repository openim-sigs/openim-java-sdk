package org.ccs.openim.chat.resp;

import lombok.Data;

import java.util.Map;

@Data
public class GetClientConfigResp {
    private Map<String, String> config;
}
