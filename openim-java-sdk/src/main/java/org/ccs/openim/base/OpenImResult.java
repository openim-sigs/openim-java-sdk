package org.ccs.openim.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class OpenImResult<T> implements Serializable {
    public boolean isOk() {
        return errCode != null && errCode == 0;
    }

    private String errDlt;

    private T data;

    private Integer errCode;

    private String errMsg;

}
