package org.ccs.openim.config;

import lombok.Data;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.IMPlatform;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "openim")
@Data
public class OpenimDefaultConfiguration extends OpenimConfig {
    private String api = "http://openim-web.host.fit";
    private String apiApi = "";
    private String apiChat = "";
    private String apiAdmin = "";
    private String secret = "openIM123";
    private Integer platformId = IMPlatform.WINDOWS.getType();

    private String adminAccount;
    private String adminPwd;
    private String authKey;

}
