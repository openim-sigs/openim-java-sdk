package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.clientconfig.req.DelClientConfigReq;
import org.ccs.openim.admin.clientconfig.req.SetClientConfigReq;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * openIm-chat.admin服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImAdminClientConfigRest {
    public OpenImAdminClientConfigRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 获取客户端初始化配置
     *
     * @return
     */
    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/client_config/get");
        
        String body = "{}";
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<GetClientConfigResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetClientConfigResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getClientConfig--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 设置客户端初始化配置
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setClientConfig(OpenImToken openImToken, SetClientConfigReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/client_config/set");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setClientConfig--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 删除客户端初始化配置
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delClientConfig(OpenImToken openImToken, DelClientConfigReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/client_config/del");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delClientConfig--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
