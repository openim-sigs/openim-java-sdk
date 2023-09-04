package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.OpenImChatRest;
import org.ccs.openim.chat.req.*;
import org.ccs.openim.chat.resp.*;
import org.ccs.openim.constants.IMPlatform;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImChatRestTest {

    @Resource
    private OpenImChatRest openImChatRest;


    private static OpenImToken openImToken;

    @Before
    public void initToken() {
        if (openImToken == null) {
            String operationId = IdUtil.fastUUID();
            LoginReq loginReq = new LoginReq();
            loginReq.setPlatform(IMPlatform.WINDOWS.getType());
            loginReq.setAreaCode("+86");
            loginReq.setPhoneNumber("17607559255");
            loginReq.setPassword("16d7a4fca7442dda3ad93c9a726597e4");
            OpenImResult<LoginResp> result = openImChatRest.login(loginReq, operationId);
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
        OpenImResult result = openImChatRest.login(loginReq, operationId);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());

    }

    @Test
    public void update() {
        UpdateUserInfoReq update = new UpdateUserInfoReq();
        update.setEmail("test@baidu.com");
        update.setNickname("justin");
        OpenImResult<String> result = openImChatRest.update(openImToken, update);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserFull() {
        FindUserFullInfoReq req = new FindUserFullInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserFullInfoResp> result = openImChatRest.findUserFull(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findUserPublic() {
        FindUserPublicInfoReq req = new FindUserPublicInfoReq();
        List<String> userIds = Arrays.asList("2837113445", "123");
        req.setUserIDs(userIds);
        OpenImResult<FindUserPublicInfoResp> result = openImChatRest.findUserPublic(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserPublic() {
        SearchUserPublicInfoReq req = new SearchUserPublicInfoReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserPubliclInfoResp> result = openImChatRest.searchUserPublic(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchUserFull() {
        SearchUserFullInfoReq req = new SearchUserFullInfoReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination());
        OpenImResult<SearchUserFullInfoResp> result = openImChatRest.searchUserFull(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletFind() {
        FindAppletReq req = new FindAppletReq();
        OpenImResult<FindAppletResp> result = openImChatRest.appletFind(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        GetClientConfigReq req = new GetClientConfigReq();
        OpenImResult<GetClientConfigResp> result = openImChatRest.getClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
