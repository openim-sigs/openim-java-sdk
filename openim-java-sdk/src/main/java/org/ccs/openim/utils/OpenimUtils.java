package org.ccs.openim.utils;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要初始化openimConfig这个配置
 *
 * @author chenjh
 */
@Slf4j
public class OpenimUtils {
    private static OpenimConfig openimConfig = new OpenimConfig();

    public static OpenimConfig getOpenimConfig() {
        return openimConfig;
    }

    public static void setOpenimConfig(OpenimConfig openimConfiguration) {
        BeanUtil.copyProperties(openimConfiguration, openimConfig);
        log.info("----openimConfig={}", openimConfig);
    }

    public static Map<String, String> adminHeaderMap(OpenImToken openImToken) {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("authKey", openimConfig.getAuthKey());
        requestHeaders.put(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.put(OpenimParams.TOKEN, openImToken.getAdminToken());
        return requestHeaders;
    }

    public static Map<String, String> apiHeaderMap(OpenImToken openImToken) {
        Map<String, String> requestHeaders = new HashMap<>(4);
        requestHeaders.put("authKey", openimConfig.getAuthKey());
        requestHeaders.put(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.put(OpenimParams.TOKEN, openImToken.getImToken());
        return requestHeaders;
    }

    public static Map<String, String> chatHeaderMap(OpenImToken openImToken) {
        Map<String, String> requestHeaders = new HashMap<>(4);
        requestHeaders.put("authKey", openimConfig.getAuthKey());
        requestHeaders.put(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.put(OpenimParams.TOKEN, openImToken.getChatToken());
        return requestHeaders;
    }
}
