package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class SingleDetail {
    private String userID;
    private String status;
    private List<SinglePlatformToken> singlePlatformToken;
}
