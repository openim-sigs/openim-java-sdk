package org.ccs.openim.chat.account.resp;

import lombok.Data;

import java.util.Map;

@Data
public class FindUserAccountResp {
    Map<String, Object> userAccountMap;
}
