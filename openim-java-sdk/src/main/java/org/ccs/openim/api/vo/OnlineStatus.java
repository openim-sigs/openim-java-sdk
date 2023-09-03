package org.ccs.openim.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class OnlineStatus {
    private String userID;
    private Integer status;
    private List<Integer> platformIDs;
}
