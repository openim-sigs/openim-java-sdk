package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiUserRest;
import org.ccs.openim.api.user.req.*;
import org.ccs.openim.api.user.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;

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
    public OpenImResult<String> userRegister(OpenImToken openImToken, UserRegisterReq req) {
        ValidatorUtils.validate(req);
        return openImApiUserRest.userRegister(openImToken, req);
    }

    /**
     * 更新用户在IM中的资料，主要是头像、昵称
     * routePath=/user/update_user_info
     *
     * @param req
     * @return
     */
    public OpenImResult<String> updateUserInfo(OpenImToken openImToken, UpdateUserInfoReq req) {
        ValidatorUtils.validate(req);
        return openImApiUserRest.updateUserInfo(openImToken, req);
    }

    /**
     * 更新用户在IM中的资料，主要是头像、昵称
     * routePath=/user/update_user_info_ex
     *
     * @param req
     * @return
     */
    public OpenImResult<String> updateUserInfoEx(OpenImToken openImToken, UpdateUserInfoExReq req) {
        ValidatorUtils.validate(req);
        return openImApiUserRest.updateUserInfoEx(openImToken, req);
    }

    /**
     * 用户信息查询
     * routePath=/user/get_users_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignateUsersResp> getUsersPublicInfo(OpenImToken openImToken, GetDesignateUsersReq req) {
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.getUsersStatus(openImToken, req);
    }

    /**
     * getSubscribeUsersStatus
     * routePath=/user/get_subscribe_users_status
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSubscribeUsersStatusResp> getSubscribeUsersStatus(OpenImToken openImToken, GetSubscribeUsersStatusReq req) {
        ValidatorUtils.validate(req);
        return openImApiUserRest.getSubscribeUsersStatus(openImToken, req);
    }

    /**
     * Get user online status.
     * routePath=/user/get_users_online_status
     *
     * @param req
     * @return
     */
    public OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>> getUsersOnlineStatus(OpenImToken openImToken, GetUsersOnlineStatusReq req) {
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.accountCheck(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.processUserCommandAdd(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.processUserCommandUpdate(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.processUserCommandDelete(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.processUserCommandGet(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.processUserCommandGetAll(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.addNotificationAccount(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.updateNotificationAccountInfo(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImApiUserRest.searchNotificationAccount(openImToken, req);
    }
}
