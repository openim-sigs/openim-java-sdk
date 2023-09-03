package org.ccs.openim.chat.resp;

import lombok.Data;

import java.util.Map;

@Data
public class FindUserAccountResp {
    Map<String, Object> userAccountMap;
}
