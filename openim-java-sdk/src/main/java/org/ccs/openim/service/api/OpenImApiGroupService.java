package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiGroupRest;
import org.ccs.openim.api.group.req.*;
import org.ccs.openim.api.group.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;


public class OpenImApiGroupService {

    private OpenImApiGroupRest openImApiGroupRest = new OpenImApiGroupRest();

    /**
     * 创建群
     *
     * @param req
     * @return
     */
    public OpenImResult<CreateGroupResp> createGroup(OpenImToken openImToken, CreateGroupReq req) {
        return openImApiGroupRest.createGroup(openImToken, req);
    }

    /**
     * 设置群信息
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setGroupInfo(OpenImToken openImToken, SetGroupInfoReq req) {
        return openImApiGroupRest.setGroupInfo(openImToken, req);
    }

    /**
     * 获取指定群信息
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupsInfoResp> getGroupInfo(OpenImToken openImToken, GetGroupsInfoReq req) {
        return openImApiGroupRest.getGroupInfo(openImToken, req);
    }


    /**
     * （以管理员或群主身份）获取群的加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupApplicationListResp> getRecvGroupApplicationList(OpenImToken openImToken, GetGroupApplicationListReq req) {
        return openImApiGroupRest.getRecvGroupApplicationList(openImToken, req);
    }

    /**
     * 获取用户自己的主动加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetUserReqApplicationListResp> getUserReqApplicationList(OpenImToken openImToken, GetUserReqApplicationListReq req) {
        return openImApiGroupRest.getUserReqApplicationList(openImToken, req);
    }

    /**
     * 获取该群用户的加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupUsersReqApplicationListResp> getGroupUsersReqApplicationList(OpenImToken openImToken, GetGroupUsersReqApplicationListReq req) {
        return openImApiGroupRest.getGroupUsersReqApplicationList(openImToken, req);
    }

    /**
     * 设置群成员昵称
     * 设置群成员信息
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setGroupMemberInfo(OpenImToken openImToken, SetGroupMemberInfoReq req) {
        return openImApiGroupRest.setGroupMemberInfo(openImToken, req);
    }

    /**
     * 获取群信息hash值
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupAbstractInfoResp> getGroupAbstractInfo(OpenImToken openImToken, GetGroupAbstractInfoReq req) {
        return openImApiGroupRest.getGroupAbstractInfo(openImToken, req);
    }

    /**
     * 申请加群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> joinGroup(OpenImToken openImToken, JoinGroupReq req) {
        return openImApiGroupRest.joinGroup(openImToken, req);
    }

    /**
     * 退出群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> quitGroup(OpenImToken openImToken, QuitGroupReq req) {
        return openImApiGroupRest.quitGroup(openImToken, req);
    }

    /**
     * 踢出群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> kickGroupMember(OpenImToken openImToken, KickGroupMemberReq req) {
        return openImApiGroupRest.kickGroupMember(openImToken, req);
    }

    /**
     * 解散群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> dismissGroup(OpenImToken openImToken, DismissGroupReq req) {
        return openImApiGroupRest.dismissGroup(openImToken, req);
    }

    /**
     * 对某个群成员禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> muteGroupMember(OpenImToken openImToken, MuteGroupMemberReq req) {
        return openImApiGroupRest.muteGroupMember(openImToken, req);
    }

    /**
     * 对某个群成员取消禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> cancelMuteGroupMember(OpenImToken openImToken, CancelMuteGroupMemberReq req) {
        return openImApiGroupRest.cancelMuteGroupMember(openImToken, req);
    }

    /**
     * 对某个群禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> muteGroup(OpenImToken openImToken, MuteGroupReq req) {
        return openImApiGroupRest.muteGroup(openImToken, req);
    }

    /**
     * 对某个群取消禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> cancelMuteGroup(OpenImToken openImToken, CancelMuteGroupReq req) {
        return openImApiGroupRest.cancelMuteGroup(openImToken, req);
    }

    /**
     * 群主或管理员处理进群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<String> applicationGroupResponse(OpenImToken openImToken, GroupApplicationResponseReq req) {
        return openImApiGroupRest.applicationGroupResponse(openImToken, req);
    }

    /**
     * 获取某个群的群成员
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupMemberListResp> getGroupMemberList(OpenImToken openImToken, GetGroupMemberListReq req) {
        return openImApiGroupRest.getGroupMemberList(openImToken, req);
    }

    /**
     * 获取某个群的指定群成员
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupMembersInfoResp> getGroupMembersInfo(OpenImToken openImToken, GetGroupMembersInfoReq req) {
        return openImApiGroupRest.getGroupMembersInfo(openImToken, req);
    }

    /**
     * 转让群主
     *
     * @param req
     * @return
     */
    public OpenImResult<String> transferGroupOwner(OpenImToken openImToken, TransferGroupOwnerReq req) {
        return openImApiGroupRest.transferGroupOwner(openImToken, req);
    }
}
