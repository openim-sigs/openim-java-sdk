package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.chat.user.resp.FindUserFullInfoResp;
import org.ccs.openim.chat.user.resp.FindUserPublicInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserFullInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserPubliclInfoResp;
import org.ccs.openim.chat.user.req.*;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * openIm-chat服务接口
 *
 * @author chenjh
 */
@Service
@Slf4j
public class OpenImChatUserRest {
    @Autowired
    private RestTemplate restTemplate;

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getChatToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

    private OpenimConfig openimConfig;

    @PostConstruct
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----update--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<FindUserFullInfoResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<FindUserFullInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findUserFull--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<FindUserPublicInfoResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<FindUserPublicInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----findUserFull--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SearchUserFullInfoResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SearchUserFullInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchUserFull--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SearchUserPubliclInfoResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SearchUserPubliclInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchUserPublic--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
