package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.defaultGroup.req.AddDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.DelDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.FindDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.SearchDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.resp.FindDefaultGroupResp;
import org.ccs.openim.admin.defaultGroup.resp.SearchDefaultGroupResp;
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
public class OpenImAdminDefaultGroupRest {
    public OpenImAdminDefaultGroupRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;

    private OpenimConfig openimConfig;

    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 添加注册时默认群
     * routePath=/default/group/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addDefaultGroup(OpenImToken openImToken, AddDefaultGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/group/add");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addDefaultGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 删除注册时默认群
     * routePath=/default/group/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delDefaultGroup(OpenImToken openImToken, DelDefaultGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/group/del");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delDefaultGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取注册时默认群列表
     * routePath=/default/group/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindDefaultGroupResp> findDefaultGroup(OpenImToken openImToken, FindDefaultGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/group/find");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<FindDefaultGroupResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<FindDefaultGroupResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findDefaultGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取注册时默认群列表
     * routePath=/default/group/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchDefaultGroupResp> searchDefaultGroup(OpenImToken openImToken, SearchDefaultGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/group/search");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchDefaultGroupResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchDefaultGroupResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchDefaultGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
