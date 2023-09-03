package org.ccs.openim.base;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.Data;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;

@Data
public class OpenimConfig {
    private String api;
    private String apiApi;
    private String apiChat;
    private String apiAdmin;
    private String secret;
    private Integer platformId;

    private String adminAccount;
    private String adminPwd;
    private String authKey;

    public String getApiUrl(ApiServerType serverType) {
        if (ApiServerType.API == serverType && CharSequenceUtil.isNotBlank(apiApi)) {
            return apiApi;
        } else if (ApiServerType.CHAT == serverType && CharSequenceUtil.isNotBlank(apiChat)) {
            return apiChat;
        } else if (ApiServerType.ADMIN == serverType && CharSequenceUtil.isNotBlank(apiAdmin)) {
            return apiAdmin;
        }
        return CommUtils.appendUrl(api, serverType.getApiPath());
    }
}
