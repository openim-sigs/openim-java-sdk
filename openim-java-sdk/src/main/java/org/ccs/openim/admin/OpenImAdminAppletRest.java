package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.applet.req.AddAppletReq;
import org.ccs.openim.admin.applet.req.DelAppletReq;
import org.ccs.openim.admin.applet.req.SearchAppletReq;
import org.ccs.openim.admin.applet.req.UpdateAppletReq;
import org.ccs.openim.admin.applet.resp.SearchAppletResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.http.*;

/**
 * openIm-chat.admin服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImAdminAppletRest {
    public OpenImAdminAppletRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getAdminToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 添加小程序
     * routePath=/applet/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletAdd(OpenImToken openImToken, AddAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/add");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletAdd--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 删除小程序
     * routePath=/applet/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletDel(OpenImToken openImToken, DelAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/del");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletDel--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 修改小程序
     * routePath=/applet/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletUpdate(OpenImToken openImToken, UpdateAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/update");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletUpdate--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 搜索小程序
     * routePath=/applet/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchAppletResp> appletSearch(OpenImToken openImToken, SearchAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/search");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SearchAppletResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SearchAppletResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletSearch--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
