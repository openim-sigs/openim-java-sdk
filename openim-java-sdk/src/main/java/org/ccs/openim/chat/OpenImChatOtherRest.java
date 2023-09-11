package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.chat.req.FindAppletReq;
import org.ccs.openim.chat.req.GetClientConfigReq;
import org.ccs.openim.chat.req.OpenIMCallbackReq;
import org.ccs.openim.chat.req.UploadLogsReq;
import org.ccs.openim.chat.resp.FindAppletResp;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;


/**
 * openIm-chat服务接口
 *
 * @author chenjh
 */

@Slf4j
public class OpenImChatOtherRest {
    public OpenImChatOtherRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;
    
    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    public OpenImResult<FindAppletResp> appletFind(OpenImToken openImToken, FindAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/find");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<FindAppletResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<FindAppletResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletFind--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken, GetClientConfigReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/client_config/get");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<GetClientConfigResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetClientConfigResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getClientConfig--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    public OpenImResult<String> callbackOpenIm(OpenImToken openImToken, OpenIMCallbackReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/callback/open_im");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----callbackOpenIm--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 上传日志
     * routePath = /logs/upload
     *
     * @param req
     * @return
     */
    public OpenImResult<String> uploadLogs(OpenImToken openImToken, UploadLogsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/logs/upload");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----uploadLogs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
