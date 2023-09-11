package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.group.req.*;
import org.ccs.openim.api.group.resp.*;
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
public class OpenImApiGroupRest {
    public OpenImApiGroupRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.API;
    

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 创建群
     *
     * @param req
     * @return
     */
    public OpenImResult<CreateGroupResp> createGroup(OpenImToken openImToken, CreateGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/create_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<CreateGroupResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<CreateGroupResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----createGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 设置群信息
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setGroupInfo(OpenImToken openImToken, SetGroupInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/set_group_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setGroupInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取指定群信息
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupsInfoResp> getGroupInfo(OpenImToken openImToken, GetGroupsInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_groups_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupsInfoResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupsInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * （以管理员或群主身份）获取群的加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupApplicationListResp> getRecvGroupApplicationList(OpenImToken openImToken, GetGroupApplicationListReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_recv_group_applicationList");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupApplicationListResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupApplicationListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getRecvGroupApplicationList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取用户自己的主动加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetUserReqApplicationListResp> getUserReqApplicationList(OpenImToken openImToken, GetUserReqApplicationListReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_user_req_group_applicationList");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetUserReqApplicationListResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetUserReqApplicationListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getUserReqApplicationList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取该群用户的加群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupUsersReqApplicationListResp> getGroupUsersReqApplicationList(OpenImToken openImToken, GetGroupUsersReqApplicationListReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_group_users_req_application_list");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupUsersReqApplicationListResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupUsersReqApplicationListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupUsersReqApplicationList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 设置群成员昵称
     * 设置群成员信息
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setGroupMemberInfo(OpenImToken openImToken, SetGroupMemberInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/set_group_member_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setGroupMemberInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取群信息hash值
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupAbstractInfoResp> getGroupAbstractInfo(OpenImToken openImToken, GetGroupAbstractInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_group_abstract_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupAbstractInfoResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupAbstractInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setGroupMemberInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 申请加群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> joinGroup(OpenImToken openImToken, JoinGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/join_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----joinGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 退出群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> quitGroup(OpenImToken openImToken, QuitGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/quit_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----quitGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 踢出群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> kickGroupMember(OpenImToken openImToken, KickGroupMemberReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/kick_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----quitGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 解散群
     *
     * @param req
     * @return
     */
    public OpenImResult<String> dismissGroup(OpenImToken openImToken, DismissGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/dismiss_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----dismissGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 对某个群成员禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> muteGroupMember(OpenImToken openImToken, MuteGroupMemberReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/mute_group_member");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----muteGroupMember--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 对某个群成员取消禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> cancelMuteGroupMember(OpenImToken openImToken, CancelMuteGroupMemberReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/cancel_mute_group_member");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----cancelMuteGroupMember--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 对某个群禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> muteGroup(OpenImToken openImToken, MuteGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/mute_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----muteGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 对某个群取消禁言
     *
     * @param req
     * @return
     */
    public OpenImResult<String> cancelMuteGroup(OpenImToken openImToken, CancelMuteGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/cancel_mute_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----muteGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 群主或管理员处理进群申请
     *
     * @param req
     * @return
     */
    public OpenImResult<String> applicationGroupResponse(OpenImToken openImToken, GroupApplicationResponseReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/group_application_response");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----quitGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取某个群的群成员
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupMemberListResp> getGroupMemberList(OpenImToken openImToken, GetGroupMemberListReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_group_member_list");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupMemberListResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupMemberListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----quitGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取某个群的指定群成员
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupMembersInfoResp> getGroupMembersInfo(OpenImToken openImToken, GetGroupMembersInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_group_members_info");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupMembersInfoResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupMembersInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupMembersInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 转让群主
     *
     * @param req
     * @return
     */
    public OpenImResult<String> transferGroupOwner(OpenImToken openImToken, TransferGroupOwnerReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/transfer_group");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----transferGroupOwner--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 转让群主
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupsResp> getGroups(OpenImToken openImToken, GetGroupsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_groups");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupsResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroups--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取群成员用户ID
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupMemberUserIDsResp> getGroupMemberUserIDs(OpenImToken openImToken, GetGroupMemberUserIDsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/group/get_groups");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupMemberUserIDsResp>
                openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupMemberUserIDsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupMemberUserIDs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
