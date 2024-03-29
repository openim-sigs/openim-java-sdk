package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.user.req.*;
import org.ccs.openim.api.user.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */

@Slf4j
public class OpenImApiUserRest {
    public OpenImApiUserRest() {
        this.init();
    }


    public static final ApiServerType SERVER_TYPE = ApiServerType.API;

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }


    /**
     * 一般是通过业务服务器（如chat服务器）完成用户的账号注册后，再注册到IM系统中，这样业务系统和IM系统完成账号打通。
     * routePath=/user/user_register
     *
     * @param req
     * @return
     */
    public OpenImResult<String> userRegister(OpenImToken openImToken, UserRegisterReq req) {
//        ValidateUtils.notNull(users, "users is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/user_register");

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(OpenimParams.OPERATIONID, openImToken.getOperationId());

        if (CharSequenceUtil.isBlank(req.getSecret())) {
            req.setSecret(openimConfig.getSecret());
        }
        String body = JSONUtil.toJsonStr(req);

        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, headerMap);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userRegister--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Check if userID exists
     * routePath=/user/account_check
     *
     * @param req
     * @return
     */
    public OpenImResult<AccountCheckResp> accountCheck(OpenImToken openImToken, AccountCheckReq req) {
//        ValidateUtils.notNullForCoding(userInfo, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/account_check");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<AccountCheckResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<AccountCheckResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 更新用户在IM中的资料，主要是头像、昵称
     * routePath=/user/update_user_info
     *
     * @param userInfo
     * @return
     */
    public OpenImResult<String> updateUserInfo(OpenImToken openImToken, UpdateUserInfoReq userInfo) {
//        ValidateUtils.notNullForCoding(userInfo, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/update_user_info");


        String body = JSONUtil.toJsonStr(userInfo);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 更新用户在IM中的资料，主要是头像、昵称
     * routePath=/user/update_user_info_ex
     *
     * @param userInfo
     * @return
     */
    public OpenImResult<String> updateUserInfoEx(OpenImToken openImToken, UpdateUserInfoExReq userInfo) {
//        ValidateUtils.notNullForCoding(userInfo, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/update_user_info_ex");


        String body = JSONUtil.toJsonStr(userInfo);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfoEx--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 用户信息查询
     * routePath=/user/get_users_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignateUsersResp> getUsersPublicInfo(OpenImToken openImToken, GetDesignateUsersReq req) {
//        ValidateUtils.notNullForCoding(userInfo, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_users_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetDesignateUsersResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetDesignateUsersResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 设置用户全局免打扰，所有消息的接收属于静默状态，无推送提醒。
     * Set user message receiving options
     * routePath=/user/set_global_msg_recv_opt
     *
     * @param req
     * @return
     */
    public OpenImResult<String> globalRecvMsgOpt(OpenImToken openImToken, SetGlobalRecvMessageOptReq req) {
//        ValidateUtils.notNullForCoding(userId, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/set_global_msg_recv_opt");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----globalRecvMsgOpt--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Turn the page (or specify userID, nickname) to pull user information Full field
     * routePath=/user/get_users
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationUsersResp> getUsers(OpenImToken openImToken, GetPaginationUsersReq req) {
//        ValidateUtils.notNullForCoding(userId, "userInfo is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_users");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));
        OpenImResult<GetPaginationUsersResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetPaginationUsersResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsers--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Get all user IDs
     * routePath=/user/get_all_users_uid
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAllUserIDResp> getAllUsersID(OpenImToken openImToken, GetAllUserIDReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_all_users_uid");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetAllUserIDResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetAllUserIDResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getAllUsersID--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Get the online status of the user.
     * routePath=/user/get_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<GetUserStatusResp> getUsersStatus(OpenImToken openImToken, GetUserStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_users_status");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetUserStatusResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetUserStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Get the online status of subscribers
     * routePath=/user/get_subscribe_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSubscribeUsersStatusResp> getSubscribeUsersStatus(OpenImToken openImToken, GetSubscribeUsersStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_subscribe_users_status");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetSubscribeUsersStatusResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetSubscribeUsersStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getSubscribeUsersStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * Get user online status.
     * routePath=/user/get_users_online_status
     *
     * @param req
     * @return
     */
    public OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>> getUsersOnlineStatus(OpenImToken openImToken, GetUsersOnlineStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_users_online_status");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersOnlineStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Get user online token details.
     * routePath=/user/get_users_online_token_detail
     *
     * @param req
     * @return
     */
    public OpenImResult<List<SingleDetail>> getUsersOnlineTokenDetail(OpenImToken openImToken, GetUsersOnlineStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/get_users_online_token_detail");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<List<SingleDetail>>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<List<SingleDetail>>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersOnlineTokenDetail--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * subscriberStatus 订阅用户状态
     * Presence status of subscribed users.
     * routePath=/user/subscribe_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<SubscribeOrCancelUsersStatusResp> subscriberStatus(OpenImToken openImToken, SubscribeOrCancelUsersStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/subscribe_users_status");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<SubscribeOrCancelUsersStatusResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SubscribeOrCancelUsersStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----subscriberStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * unsubscriberStatus 取消订阅用户状态
     * Unsubscribe a user's presence.
     * routePath=/user/unsubscribe_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<SubscribeOrCancelUsersStatusResp> unsubscriberStatus(OpenImToken openImToken, SubscribeOrCancelUsersStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/unsubscribe_users_status");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<SubscribeOrCancelUsersStatusResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SubscribeOrCancelUsersStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----unsubscriberStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * add a general function for add
     * <p>
     * routePath=/user/process_user_command_add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> processUserCommandAdd(OpenImToken openImToken, ProcessUserCommandAddReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/process_user_command_add");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----processUserCommandAdd--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * add a general function for update
     * <p>
     * routePath=/user/process_user_command_update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> processUserCommandUpdate(OpenImToken openImToken, ProcessUserCommandUpdateReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/process_user_command_update");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----processUserCommandUpdate--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * add a general function for delete
     * <p>
     * routePath=/user/process_user_command_delete
     *
     * @param req
     * @return
     */
    public OpenImResult<String> processUserCommandDelete(OpenImToken openImToken, ProcessUserCommandDeleteReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/process_user_command_delete");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----processUserCommandDelete--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * add a general function for get
     * <p>
     * routePath=/user/process_user_command_get
     *
     * @param req
     * @return
     */
    public OpenImResult<ProcessUserCommandGetResp> processUserCommandGet(OpenImToken openImToken, ProcessUserCommandGetReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/process_user_command_get");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<ProcessUserCommandGetResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<ProcessUserCommandGetResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----processUserCommandGet--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * add a general function for get
     * <p>
     * routePath=/user/process_user_command_get
     *
     * @param req
     * @return
     */
    public OpenImResult<ProcessUserCommandGetAllResp> processUserCommandGetAll(OpenImToken openImToken, ProcessUserCommandGetAllReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/process_user_command_get_all");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<ProcessUserCommandGetAllResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<ProcessUserCommandGetAllResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----processUserCommandGetAll--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * add a system notification account
     * <p>
     * routePath=/user/add_notification_account
     *
     * @param req
     * @return
     */
    public OpenImResult<AddNotificationAccountResp> addNotificationAccount(OpenImToken openImToken, AddNotificationAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/add_notification_account");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<AddNotificationAccountResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<AddNotificationAccountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addNotificationAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * update the system notification info
     * <p>
     * routePath=/user/update_notification_account
     *
     * @param req
     * @return
     */
    public OpenImResult<String> updateNotificationAccountInfo(OpenImToken openImToken, UpdateNotificationAccountInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/update_notification_account");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateNotificationAccountInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * update the system notification info
     * <p>
     * routePath=/user/search_notification_account
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchNotificationAccountResp> searchNotificationAccount(OpenImToken openImToken, SearchNotificationAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/search_notification_account");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<SearchNotificationAccountResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchNotificationAccountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchNotificationAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
