package org.ccs.openim.admin.req;

import lombok.Data;

import java.util.List;

@Data
public class DelClientConfigReq {
    private List<String> keys;
}
