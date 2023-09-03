package org.ccs.openim.chat.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResp implements Serializable {
    private String chatToken;

    private String imToken;

    private String userID;

}
