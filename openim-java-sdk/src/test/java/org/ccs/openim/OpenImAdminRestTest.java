package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.OpenImAdminClientConfigRest;
import org.ccs.openim.admin.OpenImAdminDefaultUserRest;
import org.ccs.openim.admin.OpenImAdminRest;
import org.ccs.openim.admin.clientconfig.req.DelClientConfigReq;
import org.ccs.openim.admin.clientconfig.req.SetClientConfigReq;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.admin.defaultUser.req.AddDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.DelDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.FindDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.SearchDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.resp.FindDefaultFriendResp;
import org.ccs.openim.admin.defaultUser.resp.SearchDefaultFriendResp;
import org.ccs.openim.admin.req.GetAdminInfoReq;
import org.ccs.openim.admin.req.AdminLoginReq;
import org.ccs.openim.admin.req.SearchLogsReq;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.admin.resp.GetAdminInfoResp;
import org.ccs.openim.admin.resp.SearchLogsResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.user.req.UpdateUserInfoReq;
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

    @Resource
    private OpenImAdminClientConfigRest openImAdminClientConfigRest;
    @Resource
    private OpenImAdminDefaultUserRest openImAdminDefaultUserRest;

    private static OpenImToken openImToken;

    @Before
    public void initToken() {
        if (openImToken == null) {
            String operationId = IdUtil.fastUUID();
            AdminLoginReq adminLoginReq = new AdminLoginReq();
            adminLoginReq.setAccount("openIMAdmin");
            adminLoginReq.setPassword("de84e3477e4fcddc54c9bfbeac4aca2d");
            OpenImResult<AdminLoginResp> result = openImAdminRest.adminLogin(adminLoginReq, operationId);
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
    public void adminInfo() {
        GetAdminInfoReq req = new GetAdminInfoReq();
        OpenImResult<GetAdminInfoResp> result = openImAdminRest.adminInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());

    }

    @Test
    public void adminUpdateInfo() {
        UpdateUserInfoReq getAdminInfoResp = new UpdateUserInfoReq();
        getAdminInfoResp.setAccount("openIMAdmin");
        getAdminInfoResp.setNickname("system30");
        OpenImResult result = openImAdminRest.adminUpdateInfo(openImToken, getAdminInfoResp);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        OpenImResult<GetClientConfigResp> result = openImAdminClientConfigRest.getClientConfig(openImToken);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void setClientConfig() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aaa", "aaa");
        SetClientConfigReq req = new SetClientConfigReq();
        req.setConfig(paramMap);
        OpenImResult result = openImAdminClientConfigRest.setClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }


    @Test
    public void delClientConfig() {
        List<String> keys = Arrays.asList("aaa");
        DelClientConfigReq req = new DelClientConfigReq();
        req.setKeys(keys);
        OpenImResult result = openImAdminClientConfigRest.delClientConfig(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }


    @Test
    public void delDefaultFriend() {
        DelDefaultFriendReq req = new DelDefaultFriendReq();
        req.setUserIDs(Arrays.asList("1234"));
        OpenImResult result = openImAdminDefaultUserRest.delDefaultFriend(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void addDefaultFriend() {
        AddDefaultFriendReq req = new AddDefaultFriendReq();
        req.setUserIDs(Arrays.asList("1234"));
        OpenImResult result = openImAdminDefaultUserRest.addDefaultFriend(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void findDefaultFriend() {
        FindDefaultFriendReq req = new FindDefaultFriendReq();
        OpenImResult<FindDefaultFriendResp> result = openImAdminDefaultUserRest.findDefaultFriend(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchDefaultFriend() {
        SearchDefaultFriendReq req = new SearchDefaultFriendReq();
        req.setKeyword("test");
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<SearchDefaultFriendResp> result = openImAdminDefaultUserRest.searchDefaultFriend(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchLogs(){
        SearchLogsReq req = new SearchLogsReq();
        req.setKeyword("test");
        Long curTime = System.currentTimeMillis();
        req.setStartTime(curTime);
        req.setEndTime(curTime-864000*1000*3);
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<SearchLogsResp> result = openImAdminRest.searchLogs(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
