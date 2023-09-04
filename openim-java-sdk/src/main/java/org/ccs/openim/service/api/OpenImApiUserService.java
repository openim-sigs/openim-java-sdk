package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiUserRest;
import org.ccs.openim.api.user.req.*;
import org.ccs.openim.api.user.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;

import java.util.List;


public class OpenImApiUserService {

    private OpenImApiUserRest openImApiUserRest = new OpenImApiUserRest();


    /**
     * 一般是通过业务服务器（如chat服务器）完成用户的账号注册后，再注册到IM系统中，这样业务系统和IM系统完成账号打通。
     * routePath=/user/user_register
     *
     * @param req
     * @return
     */
    public OpenImResult<String> userRegister(UserRegisterReq req) {
        return openImApiUserRest.userRegister(req);
    }

    /**
     * 更新用户在IM中的资料，主要是头像、昵称
     * routePath=/user/update_user_info
     *
     * @param userInfo
     * @return
     */
    public OpenImResult<String> updateUserInfo(OpenImToken openImToken, UpdateUserInfoReq userInfo) {
        return openImApiUserRest.updateUserInfo(openImToken, userInfo);
    }

    /**
     * 用户信息查询
     * routePath=/user/get_users_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignateUsersResp> getUsersPublicInfo(OpenImToken openImToken, GetDesignateUsersReq req) {
        return openImApiUserRest.getUsersPublicInfo(openImToken, req);
    }

    /**
     * Turn the page (or specify userID, nickname) to pull user information Full field
     * routePath=/user/get_users
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationUsersResp> getUsers(OpenImToken openImToken, GetPaginationUsersReq req) {
        return openImApiUserRest.getUsers(openImToken, req);
    }

    /**
     * Get all user IDs
     * routePath=/user/get_all_users_uid
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAllUserIDResp> getAllUsersID(OpenImToken openImToken, GetAllUserIDReq req) {
        return openImApiUserRest.getAllUsersID(openImToken, req);
    }

    /**
     * getUsersStatus
     * routePath=/user/get_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<GetUserStatusResp> getUsersStatus(OpenImToken openImToken, GetUserStatusReq req) {
        return openImApiUserRest.getUsersStatus(openImToken, req);
    }

    /**
     * Get user online status.
     * routePath=/user/get_users_online_status
     *
     * @param req
     * @return
     */
    public OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>> getUsersOnlineStatus(OpenImToken openImToken, GetUsersOnlineStatusReq req) {
        return openImApiUserRest.getUsersOnlineStatus(openImToken, req);
    }

    /**
     * Get user online token details.
     * routePath=/user/get_users_online_token_detail
     *
     * @param req
     * @return
     */
    public OpenImResult<List<SingleDetail>> getUsersOnlineTokenDetail(OpenImToken openImToken, GetUsersOnlineStatusReq req) {
        return openImApiUserRest.getUsersOnlineTokenDetail(openImToken, req);
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
        return openImApiUserRest.subscriberStatus(openImToken, req);
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
        return openImApiUserRest.unsubscriberStatus(openImToken, req);
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
        return openImApiUserRest.globalRecvMsgOpt(openImToken, req);
    }

    /**
     * Check if userID exists
     * routePath=/user/account_check
     *
     * @param req
     * @return
     */
    public OpenImResult<AccountCheckResp> accountCheck(OpenImToken openImToken, AccountCheckReq req) {
        return openImApiUserRest.accountCheck(openImToken, req);
    }
}
