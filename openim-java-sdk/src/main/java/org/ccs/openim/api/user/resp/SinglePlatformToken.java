package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class SinglePlatformToken {
    private String platform;
    private Integer total;
    private List<String> token;
}
