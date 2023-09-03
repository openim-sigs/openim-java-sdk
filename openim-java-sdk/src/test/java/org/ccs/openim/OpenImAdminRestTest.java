package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.OpenImAdminRest;
import org.ccs.openim.admin.req.*;
import org.ccs.openim.admin.req.defaultUser.AddDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.DelDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.FindDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.SearchDefaultFriendReq;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.admin.resp.GetAdminInfoResp;
import org.ccs.openim.admin.resp.defaultUser.FindDefaultFriendResp;
import org.ccs.openim.admin.resp.defaultUser.SearchDefaultFriendResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.req.UpdateUserInfoReq;
import org.ccs.openim.chat.resp.GetClientConfigResp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImAdminRestTest {

    @Resource
    private OpenImAdminRest openImAdminRest;

    private static OpenImToken openImToken;

    @Before
    public void initToken() {
        if (openImToken == null) {
            String operationId = IdUtil.fastUUID();
            LoginReq loginReq = new LoginReq();
            loginReq.setAccount("openIMAdmin");
            loginReq.setPassword("de84e3477e4fcddc54c9bfbeac4aca2d");
            OpenImResult<AdminLoginResp> result = openImAdminRest.login(loginReq, operationId);
            if (result.isOk()) {
                AdminLoginResp loginResp = result.getData();
                openImToken = new OpenImToken(operationId, loginResp.getImToken(), null, loginResp.getAdminToken(), loginResp.getImUserID());
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
    public void info() {
        GetAdminInfoReq req = new GetAdminInfoReq();
        OpenImResult<GetAdminInfoResp> result = openImAdminRest.info(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());

    }

    @Test
    public void update() {
        UpdateUserInfoReq getAdminInfoResp = new UpdateUserInfoReq();
        getAdminInfoResp.setAccount("openIMAdmin");
        getAdminInfoResp.setNickname("system30");
        OpenImResult result = openImAdminRest.update(openImToken, getAdminInfoResp);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        OpenImResult<GetClientConfigResp> result = openImAdminRest.getClientConfig(openImToken);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void setClientConfig() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aaa", "aaa");
        SetClientConfigReq req = new SetClientConfigReq();
        req.setConfig(paramMap);
        OpenImResult result = openImAdminRest.setClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }


    @Test
    public void delClientConfig() {
        List<String> keys = Arrays.asList("aaa");
        DelClientConfigReq req = new DelClientConfigReq();
        req.setKeys(keys);
        OpenImResult result = openImAdminRest.delClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletAdd() {
        AddAppletReq req = new AddAppletReq();
        req.setAppID("1235");
        req.setName("test2");
        req.setSize(10L);
        req.setCreateTime(System.currentTimeMillis());
        req.setStatus(1);
        req.setPriority(10);
        OpenImResult result = openImAdminRest.appletAdd(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletUpdate() {
        UpdateAppletReq req = new UpdateAppletReq();
        req.setId("6627f9ff-449a-4209-a5f2-765b08b4511f");
        req.setAppID("1234");
        req.setName("test2");
        req.setSize(10L);
        req.setCreateTime(System.currentTimeMillis());
        req.setStatus(1);
        req.setPriority(10);
        OpenImResult result = openImAdminRest.appletUpdate(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletSearch() {
        SearchAppletReq req = new SearchAppletReq();
        req.setKeyword("1234");
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult result = openImAdminRest.appletSearch(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletDel() {
        DelAppletReq req = new DelAppletReq();
        req.setAppletIds(Arrays.asList("6627f9ff-449a-4209-a5f2-765b08b4511f"));
        OpenImResult result = openImAdminRest.appletDel(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void defaultUserDel() {
        DelDefaultFriendReq req = new DelDefaultFriendReq();
        req.setUserIDs(Arrays.asList("1234"));
        OpenImResult result = openImAdminRest.defaultUserDel(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void defaultUserAdd() {
        AddDefaultFriendReq req = new AddDefaultFriendReq();
        req.setUserIDs(Arrays.asList("1234"));
        OpenImResult result = openImAdminRest.defaultUserAdd(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void defaultUserFind() {
        FindDefaultFriendReq req = new FindDefaultFriendReq();
        OpenImResult<FindDefaultFriendResp> result = openImAdminRest.defaultUserFind(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void defaultUserSearch() {
        SearchDefaultFriendReq req = new SearchDefaultFriendReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<SearchDefaultFriendResp> result = openImAdminRest.defaultUserSearch(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
