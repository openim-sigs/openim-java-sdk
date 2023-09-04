package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ccs.openim.api.user.req.*;
import org.ccs.openim.api.user.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */
@Service
@Slf4j
public class OpenImApiUserRest {
    @Autowired
    private RestTemplate restTemplate;

    public static final ApiServerType SERVER_TYPE = ApiServerType.API;


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getImToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

    private OpenimConfig openimConfig;

    @PostConstruct
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
    public OpenImResult<String> userRegister(UserRegisterReq req) {
//        ValidateUtils.notNull(users, "users is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/user_register");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(OpenimParams.OPERATIONID, "");

        if (StringUtils.isBlank(req.getSecret())) {
            req.setSecret(openimConfig.getSecret());
        }
        String body = JSONUtil.toJsonStr(req);

        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userRegister--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<AccountCheckResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<AccountCheckResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(userInfo);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetDesignateUsersResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetDesignateUsersResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----updateUserInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----globalRecvMsgOpt--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetPaginationUsersResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetPaginationUsersResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsers--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetAllUserIDResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetAllUserIDResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getAllUsersID--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetUserStatusResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetUserStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>>
                openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersOnlineStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<List<SingleDetail>>
                openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<List<SingleDetail>>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUsersOnlineTokenDetail--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SubscribeOrCancelUsersStatusResp>
                openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SubscribeOrCancelUsersStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----subscriberStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SubscribeOrCancelUsersStatusResp>
                openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SubscribeOrCancelUsersStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----unsubscriberStatus--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
