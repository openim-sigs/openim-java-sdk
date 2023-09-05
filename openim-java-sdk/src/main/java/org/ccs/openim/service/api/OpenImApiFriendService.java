package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiFriendRest;
import org.ccs.openim.api.friend.req.*;
import org.ccs.openim.api.friend.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiFriendService {
    @Resource
    private OpenImApiFriendRest openImApiFriendRest;

    /**
     * 删除好友
     * routePath=/friend/delete_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteFriend(OpenImToken openImToken, DeleteFriendReq req) {
        return openImApiFriendRest.deleteFriend(openImToken, req);
    }

    /**
     * 申请加好友
     * routePath=/friend/add_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addFriend(OpenImToken openImToken, ApplyToAddFriendReq req) {
        return openImApiFriendRest.addFriend(openImToken, req);
    }

    /**
     * 导入好友关系
     * routePath=/friend/import_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<String> importFriends(OpenImToken openImToken, ImportFriendReq req) {
        return openImApiFriendRest.importFriends(openImToken, req);
    }

    /**
     * 对好友申请响应（同意或拒绝）
     * routePath=/friend/add_friend_response
     *
     * @param req
     * @return
     */
    public OpenImResult<String> respondFriendApply(OpenImToken openImToken, RespondFriendApplyReq req) {
        return openImApiFriendRest.respondFriendApply(openImToken, req);
    }

    /**
     * 对好友申请响应（同意或拒绝）
     * routePath=/friend/set_friend_remark
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setFriendRemark(OpenImToken openImToken, SetFriendRemarkReq req) {
        return openImApiFriendRest.setFriendRemark(openImToken, req);
    }

    /**
     * 获取收到的好友申请列表
     * routePath=/friend/get_friend_apply_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsApplyToResp> getFriendApplyList(OpenImToken openImToken, GetPaginationFriendsApplyToReq req) {
        return openImApiFriendRest.getFriendApplyList(openImToken, req);
    }

    /**
     * 获取指定好友申请
     * routePath=/friend/get_designated_friend_apply
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignatedFriendsApplyResp> getDesignatedFriendsApply(OpenImToken openImToken, GetDesignatedFriendsApplyReq req) {
        return openImApiFriendRest.getDesignatedFriendsApply(openImToken, req);
    }

    /**
     * 获取主动发出去的好友申请列表
     * routePath=/friend/get_self_friend_apply_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsApplyFromResp> getSelfApplyList(OpenImToken openImToken, GetPaginationFriendsApplyFromReq req) {
        return openImApiFriendRest.getSelfApplyList(openImToken, req);
    }

    /**
     * 获取指定好友信息 有id不存在也返回错误
     * routePath=/friend/get_friend_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationFriendsResp> getFriendList(OpenImToken openImToken, GetPaginationFriendsReq req) {
        return openImApiFriendRest.getFriendList(openImToken, req);
    }

    /**
     * 翻页获取好友列表 无结果不返回错误
     * routePath=/friend/get_designated_friends
     *
     * @param req
     * @return
     */
    public OpenImResult<GetDesignatedFriendsResp> getDesignatedFriends(OpenImToken openImToken, GetDesignatedFriendsReq req) {
        return openImApiFriendRest.getDesignatedFriends(openImToken, req);
    }

    /**
     * 添加黑名单
     * routePath=/friend/add_black
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addBlack(OpenImToken openImToken, AddBlackReq req) {
        return openImApiFriendRest.addBlack(openImToken, req);
    }

    /**
     * 获取黑名单列表
     * routePath=/friend/get_black_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetPaginationBlacksResp> getPaginationBlacks(OpenImToken openImToken, GetPaginationBlacksReq req) {
        return openImApiFriendRest.getPaginationBlacks(openImToken, req);
    }

    /**
     * 移除黑名单
     * routePath=/friend/remove_black
     *
     * @param req
     * @return
     */
    public OpenImResult<String> removeBlack(OpenImToken openImToken, RemoveBlackReq req) {
        return openImApiFriendRest.removeBlack(openImToken, req);
    }

    /**
     * 判断是否好友关系
     * routePath=/friend/is_friend
     *
     * @param req
     * @return
     */
    public OpenImResult<IsFriendResp> isFriend(OpenImToken openImToken, IsFriendReq req) {
        return openImApiFriendRest.isFriend(openImToken, req);
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
        return openImApiFriendRest.isBlack(openImToken, req);
    }

    /**
     * 获取好友ID列表
     * routePath=/friend/get_friend_id
     *
     * @param req
     * @return
     */
    public OpenImResult<GetFriendIDsResp> getFriendIDs(OpenImToken openImToken, GetFriendIDsReq req) {
        return openImApiFriendRest.getFriendIDs(openImToken, req);
    }

    /**
     * 获取指定好友信息
     * routePath=/friend/get_specified_friends_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSpecifiedFriendsInfoResp> getSpecifiedFriendsInfo(OpenImToken openImToken, GetSpecifiedFriendsInfoReq req){
        return openImApiFriendRest.getSpecifiedFriendsInfo(openImToken, req);
    }
}
