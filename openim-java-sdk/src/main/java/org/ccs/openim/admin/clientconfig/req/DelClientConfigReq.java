package org.ccs.openim.admin.clientconfig.req;

import lombok.Data;

import java.util.List;

@Data
public class DelClientConfigReq {
    private List<String> keys;
}
