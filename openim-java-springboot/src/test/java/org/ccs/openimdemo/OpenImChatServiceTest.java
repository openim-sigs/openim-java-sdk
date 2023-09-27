package org.ccs.openimdemo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import junit.framework.TestCase;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.account.req.LoginReq;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.chat.req.CallbackBeforeAddFriendReq;
import org.ccs.openim.chat.req.FindAppletReq;
import org.ccs.openim.chat.req.GetClientConfigReq;
import org.ccs.openim.chat.req.OpenIMCallbackReq;
import org.ccs.openim.chat.resp.FindAppletResp;
import org.ccs.openim.chat.user.req.*;
import org.ccs.openim.chat.user.resp.FindUserFullInfoResp;
import org.ccs.openim.chat.user.resp.FindUserPublicInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserFullInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserPubliclInfoResp;
import org.ccs.openim.service.chat.OpenImChatService;
import org.ccs.openim.utils.OpenimUtils;
import org.ccs.openimdemo.config.OpenimConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimDemoApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImChatServiceTest {
    private OpenImChatService chat = new OpenImChatService();

    private static OpenImToken openImToken;

    @Resource
    private OpenimConfiguration openimConfiguration;

    @Before
    public void initToken() {
        if (openImToken == null) {
            OpenimUtils.setOpenimConfig(openimConfiguration);
            loginChat();
        }
    }

    private void loginChat() {
        String operationId = IdUtil.fastUUID();
        LoginReq loginReq = new LoginReq();
        loginReq.setPlatform(5);
        loginReq.setAreaCode("+86");
        loginReq.setPhoneNumber("17607559255");
        loginReq.setPassword("16d7a4fca7442dda3ad93c9a726597e4");
        OpenImResult<LoginResp> result = chat.account().login(loginReq, operationId);
        if (result.isOk()) {
            LoginResp loginResp = result.getData();
            openImToken = new OpenImToken(operationId, loginResp.getImToken(), loginResp.getChatToken(), null, loginResp.getUserID());
        }
    }


    @Test
    public void updateUserInfo() {
        UpdateUserInfoReq update = new UpdateUserInfoReq();
        update.setEmail("test@baidu.com");
        update.setNickname("justin");
        OpenImResult<String> result = chat.user().updateUserInfo(openImToken, update);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserFullInfo() {
        FindUserFullInfoReq req = new FindUserFullInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserFullInfoResp> result = chat.user().findUserFullInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserPublic() {
        FindUserPublicInfoReq req = new FindUserPublicInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserPublicInfoResp> result = chat.user().findUserPublicInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserPublic() {
        SearchUserPublicInfoReq req = new SearchUserPublicInfoReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserPubliclInfoResp> result = chat.user().searchUserPublicInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserFull() {
        SearchUserFullInfoReq req = new SearchUserFullInfoReq();
//        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserFullInfoResp> result = chat.user().searchUserFullInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletFind() {
        FindAppletReq req = new FindAppletReq();
        OpenImResult<FindAppletResp> result = chat.other().appletFind(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        GetClientConfigReq req = new GetClientConfigReq();
        OpenImResult<GetClientConfigResp> result = chat.other().getClientConfig(openImToken, req);
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
        OpenImResult<String> result = chat.other().callbackOpenIm(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
