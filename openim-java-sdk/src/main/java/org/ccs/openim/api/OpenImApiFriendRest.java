package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.friend.req.*;
import org.ccs.openim.api.friend.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */

@Slf4j
public class OpenImApiFriendRest {
    public OpenImApiFriendRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.API;


    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }


    /**
     * 删除好友
     * routePath=/friend/delete_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteFriend(OpenImToken openImToken, DeleteFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/delete_friend");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----deleteFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 申请加好友
     * routePath=/friend/add_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addFriend(OpenImToken openImToken, ApplyToAddFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/add_friend");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 导入好友关系
     * routePath=/friend/import_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> importFriends(OpenImToken openImToken, ImportFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/import_friend");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 对好友申请响应（同意或拒绝）
     * routePath=/friend/add_friend_response
     *
     * @param req
     * @return
     */
    public OpenImResult<String> respondFriendApply(OpenImToken openImToken, RespondFriendApplyReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/add_friend_response");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----respondFriendApply--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 对好友申请响应（同意或拒绝）
     * routePath=/friend/set_friend_remark
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setFriendRemark(OpenImToken openImToken, SetFriendRemarkReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/set_friend_remark");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----respondFriendApply--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 星标好友
     * routePath=/friend/update_friends
     *
     * @param req
     * @return
     */
    public OpenImResult<String> updateFriends(OpenImToken openImToken, UpdateFriendsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/update_friends");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateFriends--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取收到的好友申请列表
     * routePath=/friend/get_friend_apply_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsApplyToResp> getFriendApplyList(OpenImToken openImToken, GetPaginationFriendsApplyToReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_friend_apply_list");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetPaginationFriendsApplyToResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetPaginationFriendsApplyToResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getFriendApplyList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取指定好友申请
     * routePath=/friend/get_designated_friend_apply
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignatedFriendsApplyResp> getDesignatedFriendsApply(OpenImToken openImToken, GetDesignatedFriendsApplyReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_designated_friend_apply");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetDesignatedFriendsApplyResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetDesignatedFriendsApplyResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getDesignatedFriendsApply--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取主动发出去的好友申请列表
     * routePath=/friend/get_self_friend_apply_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsApplyFromResp> getSelfApplyList(OpenImToken openImToken, GetPaginationFriendsApplyFromReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_self_friend_apply_list");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetPaginationFriendsApplyFromResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetPaginationFriendsApplyFromResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getSelfApplyList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取指定好友信息 有id不存在也返回错误
     * routePath=/friend/get_friend_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsResp> getFriendList(OpenImToken openImToken, GetPaginationFriendsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_friend_list");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetPaginationFriendsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetPaginationFriendsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getFriendList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 翻页获取好友列表 无结果不返回错误
     * routePath=/friend/get_designated_friends
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignatedFriendsResp> getDesignatedFriends(OpenImToken openImToken, GetDesignatedFriendsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_designated_friends");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetDesignatedFriendsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetDesignatedFriendsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getFriendList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 添加黑名单
     * routePath=/friend/add_black
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addBlack(OpenImToken openImToken, AddBlackReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/add_black");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addBlack--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 获取黑名单列表
     * routePath=/friend/get_black_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationBlacksResp> getPaginationBlacks(OpenImToken openImToken, GetPaginationBlacksReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_black_list");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetPaginationBlacksResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetPaginationBlacksResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getPaginationBlacks--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 移除黑名单
     * routePath=/friend/remove_black
     *
     * @param req
     * @return
     */
    public OpenImResult<String> removeBlack(OpenImToken openImToken, RemoveBlackReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/remove_black");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----removeBlack--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 判断是否好友关系
     * routePath=/friend/is_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<IsFriendResp> isFriend(OpenImToken openImToken, IsFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/is_friend");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<IsFriendResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<IsFriendResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----isFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 判断是否在黑名单中(没有接口)
     * routePath=/friend/is_black
     *
     * @param req
     * @return
     * @deprecated
     */
    public OpenImResult<IsBlackResp> isBlack(OpenImToken openImToken, IsBlackReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/is_black");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<IsBlackResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<IsBlackResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----isBlack--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取好友ID列表
     * routePath=/friend/get_friend_id
     *
     * @param req
     * @return
     */
    public OpenImResult<GetFriendIDsResp> getFriendIDs(OpenImToken openImToken, GetFriendIDsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_friend_id");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetFriendIDsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetFriendIDsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getFriendIDs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取指定好友信息
     * routePath=/friend/get_specified_friends_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSpecifiedFriendsInfoResp> getSpecifiedFriendsInfo(OpenImToken openImToken, GetSpecifiedFriendsInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/get_specified_friends_info");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetSpecifiedFriendsInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetSpecifiedFriendsInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getSpecifiedFriendsInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


}
