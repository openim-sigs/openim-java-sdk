package org.ccs.openim.api.friend.resp;

import lombok.Data;
import org.ccs.openim.api.vo.PublicUserInfo;

@Data
public class BlackInfo {
    private String ownerUserID;
    private Long createTime;
    private PublicUserInfo blackUserInfo;
    private Integer addSource;
    private String operatorUserID;
    private String ex;
}