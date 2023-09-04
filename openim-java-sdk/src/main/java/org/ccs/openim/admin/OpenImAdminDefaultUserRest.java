package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.defaultUser.req.AddDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.DelDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.FindDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.SearchDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.resp.FindDefaultFriendResp;
import org.ccs.openim.admin.defaultUser.resp.SearchDefaultFriendResp;
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
public class OpenImAdminDefaultUserRest {
    public OpenImAdminDefaultUserRest() {
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
     * 添加注册时默认好友
     * routePath=/default/user/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addDefaultFriend(OpenImToken openImToken, AddDefaultFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/user/add");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addDefaultFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 删除注册时默认好友
     * routePath=/default/user/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delDefaultFriend(OpenImToken openImToken, DelDefaultFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/user/del");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delDefaultFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 默认好友列表
     * routePath=/default/user/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindDefaultFriendResp> findDefaultFriend(OpenImToken openImToken, FindDefaultFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/user/find");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<FindDefaultFriendResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<FindDefaultFriendResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findDefaultFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 搜索注册时默认好友列表
     * routePath=/default/user/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchDefaultFriendResp> searchDefaultFriend(OpenImToken openImToken, SearchDefaultFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/default/user/search");

        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SearchDefaultFriendResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SearchDefaultFriendResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchDefaultFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
