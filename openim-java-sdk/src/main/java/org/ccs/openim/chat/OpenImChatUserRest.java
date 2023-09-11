package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.chat.user.req.*;
import org.ccs.openim.chat.user.resp.FindUserFullInfoResp;
import org.ccs.openim.chat.user.resp.FindUserPublicInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserFullInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserPubliclInfoResp;
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
public class OpenImChatUserRest {
    public OpenImChatUserRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;


    private OpenimConfig openimConfig;

    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 编辑个人资料
     *
     * @param openImToken
     * @param req
     * @return
     */
    public OpenImResult<String> updateUserInfo(OpenImToken openImToken, UpdateUserInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/update");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----update--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取用户所有信息
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserFullInfoResp> findUserFullInfo(OpenImToken openImToken, FindUserFullInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/find/full");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<FindUserFullInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<FindUserFullInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findUserFullInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 获取用户公开信息
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserPublicInfoResp> findUserPublicInfo(OpenImToken openImToken, FindUserPublicInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/find/public");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<FindUserPublicInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<FindUserPublicInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findUserPublicInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 搜索用户所有信息
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserFullInfoResp> searchUserFullInfo(OpenImToken openImToken, SearchUserFullInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/search/full");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<SearchUserFullInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchUserFullInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchUserFullInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 搜索用户公开信息
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserPubliclInfoResp> searchUserPublicInfo(OpenImToken openImToken, SearchUserPublicInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/search/public");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<SearchUserPubliclInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchUserPubliclInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchUserPublicInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
