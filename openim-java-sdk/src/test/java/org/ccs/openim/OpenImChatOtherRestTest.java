package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.OpenImChatAccountRest;
import org.ccs.openim.chat.OpenImChatOtherRest;
import org.ccs.openim.chat.OpenImChatUserRest;
import org.ccs.openim.chat.account.req.LoginReq;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.chat.friend.req.SearchFriendReq;
import org.ccs.openim.chat.req.CallbackBeforeAddFriendReq;
import org.ccs.openim.chat.req.FindAppletReq;
import org.ccs.openim.chat.req.GetClientConfigReq;
import org.ccs.openim.chat.req.OpenIMCallbackReq;
import org.ccs.openim.chat.resp.FindAppletResp;
import org.ccs.openim.chat.resp.SearchUserInfoResp;
import org.ccs.openim.chat.user.req.*;
import org.ccs.openim.chat.user.resp.FindUserFullInfoResp;
import org.ccs.openim.chat.user.resp.FindUserPublicInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserFullInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserPubliclInfoResp;
import org.ccs.openim.constants.IMPlatform;
import org.ccs.openim.service.chat.OpenImChatService;
import org.ccs.openim.utils.OpenimUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImChatOtherRestTest {

    private OpenImChatOtherRest openImChatOtherRest = new OpenImChatOtherRest();

    private OpenImChatUserRest openImChatUserRest = new OpenImChatUserRest();

    private OpenImChatAccountRest openImChatAccountRest = new OpenImChatAccountRest();

    private OpenImChatService openImChatService = new OpenImChatService();


    private static OpenImToken openImToken;
    @Resource
    private OpenimConfig openimConfig;


    @Before
    public void initToken() {
        if (openImToken == null) {
            OpenimUtils.setOpenimConfig(openimConfig);
            String operationId = IdUtil.fastUUID();
            LoginReq loginReq = new LoginReq();
            loginReq.setPlatform(IMPlatform.WINDOWS.getType());
            loginReq.setAreaCode("+86");
            loginReq.setPhoneNumber("17607559255");
            loginReq.setPassword(DigestUtils.md5DigestAsHex("test".getBytes()));
            OpenImResult<LoginResp> result = openImChatAccountRest.login(loginReq, operationId);
            if (result.isOk()) {
                LoginResp loginResp = result.getData();
                openImToken = new OpenImToken(operationId, loginResp.getImToken(), loginResp.getChatToken(), null, loginResp.getUserID());
            }
        }
    }

    @Test
    public void testBody() {
        String body = "{\"errCode\":0,\"errMsg\":\"\",\"errDlt\":\"\",\"data\":{\"imToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySUQiOiIyODM3MTEzNDQ1IiwiUGxhdGZvcm1JRCI6NSwiZXhwIjoxNzAxMjQwODA4LCJuYmYiOjE2OTM0NjQ1MDgsImlhdCI6MTY5MzQ2NDgwOH0.7ItCT9ilgc68knSJxikopWQKMF4HlVg5c1OUIU4r8co\",\"chatToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySUQiOiIyODM3MTEzNDQ1IiwiVXNlclR5cGUiOjEsImV4cCI6MTcwMTI0MDgwOCwibmJmIjoxNjkzNDY0NTA4LCJpYXQiOjE2OTM0NjQ4MDh9.5SGvY2eEoYEOHX5tK8gqQn7DbpdhldovrrcNy6yP_T0\",\"userID\":\"2837113445\"}}";
        OpenImResult result = JSONUtil.toBean(body, OpenImResult.class);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void login() {
        String operationId = IdUtil.fastUUID();
        LoginReq loginReq = new LoginReq();
        loginReq.setPlatform(IMPlatform.WINDOWS.getType());
        loginReq.setAreaCode("+86");
        loginReq.setPhoneNumber("17607559255");
        loginReq.setPassword("16d7a4fca7442dda3ad93c9a726597e4");
        OpenImResult result = openImChatAccountRest.login(loginReq, operationId);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());

    }

    @Test
    public void searchFriend(){
        SearchFriendReq req = new SearchFriendReq();
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<SearchUserInfoResp> result = openImChatService.friend().searchFriend(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
    }

    @Test
    public void updateUserInfo() {
        UpdateUserInfoReq update = new UpdateUserInfoReq();
        update.setEmail("test@baidu.com");
        update.setNickname("justin");
        OpenImResult<String> result = openImChatUserRest.updateUserInfo(openImToken, update);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserFullInfo() {
        FindUserFullInfoReq req = new FindUserFullInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserFullInfoResp> result = openImChatUserRest.findUserFullInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserPublic() {
        FindUserPublicInfoReq req = new FindUserPublicInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserPublicInfoResp> result = openImChatUserRest.findUserPublicInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserPublic() {
        SearchUserPublicInfoReq req = new SearchUserPublicInfoReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserPubliclInfoResp> result = openImChatUserRest.searchUserPublicInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserFull() {
        SearchUserFullInfoReq req = new SearchUserFullInfoReq();
//        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserFullInfoResp> result = openImChatUserRest.searchUserFullInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletFind() {
        FindAppletReq req = new FindAppletReq();
        OpenImResult<FindAppletResp> result = openImChatOtherRest.appletFind(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        GetClientConfigReq req = new GetClientConfigReq();
        OpenImResult<GetClientConfigResp> result = openImChatOtherRest.getClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
    @Test
    public void callbackOpenIm() {
        CallbackBeforeAddFriendReq reqCallback = new CallbackBeforeAddFriendReq();
        reqCallback.setReqMsg("test");
        reqCallback.setFromUserID(openImToken.getUserId());
        reqCallback.setReqoperationIDMsg(openImToken.getOperationId());
        OpenIMCallbackReq req = new OpenIMCallbackReq();
        req.setCommand("callbackBeforeAddFriendCommand");
        req.setBody(JSONUtil.toJsonStr(reqCallback));
        OpenImResult<String> result = openImChatOtherRest.callbackOpenIm(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
