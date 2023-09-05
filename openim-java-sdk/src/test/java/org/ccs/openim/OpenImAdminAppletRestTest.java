package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.OpenImAdminAppletRest;
import org.ccs.openim.admin.OpenImAdminRest;
import org.ccs.openim.admin.applet.req.AddAppletReq;
import org.ccs.openim.admin.applet.req.DelAppletReq;
import org.ccs.openim.admin.applet.req.SearchAppletReq;
import org.ccs.openim.admin.applet.req.UpdateAppletReq;
import org.ccs.openim.admin.req.AdminLoginReq;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImAdminAppletRestTest {

    @Resource
    private OpenImAdminAppletRest openImAdminAppletRest;
    @Resource
    private OpenImAdminRest openImAdminRest;

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
    public void appletAdd() {
        AddAppletReq req = new AddAppletReq();
        req.setAppID("1235");
        req.setName("test2");
        req.setSize(10L);
        req.setCreateTime(System.currentTimeMillis());
        req.setStatus(1);
        req.setPriority(10);
        OpenImResult result = openImAdminAppletRest.appletAdd(openImToken, req);
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
        OpenImResult result = openImAdminAppletRest.appletUpdate(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletSearch() {
        SearchAppletReq req = new SearchAppletReq();
        req.setKeyword("1234");
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult result = openImAdminAppletRest.appletSearch(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void appletDel() {
        DelAppletReq req = new DelAppletReq();
        req.setAppletIds(Arrays.asList("6627f9ff-449a-4209-a5f2-765b08b4511f"));
        OpenImResult result = openImAdminAppletRest.appletDel(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
