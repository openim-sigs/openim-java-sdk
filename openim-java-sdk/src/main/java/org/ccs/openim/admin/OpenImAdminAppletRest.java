package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
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
public class OpenImAdminAppletRest {
    public OpenImAdminAppletRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;


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

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletAdd--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletDel--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletUpdate--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchAppletResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchAppletResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletSearch--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
