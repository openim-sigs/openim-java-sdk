package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.chat.friend.req.SearchFriendReq;
import org.ccs.openim.chat.resp.SearchUserInfoResp;
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
public class OpenImChatFriendRest {
    public OpenImChatFriendRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * routePath = /friend/search
     *
     * @param openImToken
     * @param req
     * @return
     */
    public OpenImResult<SearchUserInfoResp> searchFriend(OpenImToken openImToken, SearchFriendReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/friend/search");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<SearchUserInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchUserInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchFriend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
