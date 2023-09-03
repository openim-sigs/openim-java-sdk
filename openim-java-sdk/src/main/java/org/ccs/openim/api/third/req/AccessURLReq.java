package org.ccs.openim.api.third.req;

import lombok.Data;

import java.util.Map;

@Data
public class AccessURLReq {
    private String name;
    private Map<String, String> query;
}
