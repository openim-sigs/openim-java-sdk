package org.ccs.openim;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.api.OpenImApiAuthRest;
import org.ccs.openim.api.OpenImApiUserRest;
import org.ccs.openim.api.auth.req.ForceLogoutReq;
import org.ccs.openim.api.auth.req.ParseTokenReq;
import org.ccs.openim.api.auth.req.UserTokenReq;
import org.ccs.openim.api.auth.resp.ParseTokenResp;
import org.ccs.openim.api.auth.resp.UserTokenResp;
import org.ccs.openim.api.user.req.*;
import org.ccs.openim.api.user.resp.GetAllUserIDResp;
import org.ccs.openim.api.user.resp.GetPaginationUsersResp;
import org.ccs.openim.api.user.resp.GetUserStatusResp;
import org.ccs.openim.api.user.resp.GetUsersOnlineStatusResp_SuccessResult;
import org.ccs.openim.api.vo.UserInfo;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.OpenImChatAccountRest;
import org.ccs.openim.chat.OpenImChatOtherRest;
import org.ccs.openim.chat.account.req.LoginReq;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.constants.IMPlatform;
import org.ccs.openim.utils.OpenimUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImApiUserRestTest {

    private OpenImChatOtherRest openImChatOtherRest = new OpenImChatOtherRest();

    private OpenImChatAccountRest openImChatAccountRest = new OpenImChatAccountRest();

    private OpenImApiUserRest openImApiUserRest = new OpenImApiUserRest();

    private OpenImApiAuthRest openImApiAuthRest = new OpenImApiAuthRest();

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
    public void userToken() {
        UserTokenReq req = new UserTokenReq();
        req.setUserID("2997204749");
        OpenImResult<UserTokenResp> result = openImApiAuthRest.userToken(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySUQiOiIyODM3MTEzNDQ1IiwiUGxhdGZvcm1JRCI6NSwiZXhwIjoxNzAxMjQ2NjY3LCJuYmYiOjE2OTM0NzAzNjcsImlhdCI6MTY5MzQ3MDY2N30.QoSrSbXLb64bKWe4ItfPPr2FZ3n9jNOCc70oaxarN3M";
        ParseTokenReq req = new ParseTokenReq();
        req.setToken(token);
        OpenImResult<ParseTokenResp> result = openImApiAuthRest.parseToken(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));

        req.setToken(openImToken.getImToken());
        result = openImApiAuthRest.parseToken(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void authForceLogout() {
        ForceLogoutReq req = new ForceLogoutReq();
        req.setUserID("2997204749");
        OpenImResult<String> result = openImApiAuthRest.forceLogout(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void userRegister(){
        UserRegisterReq userRegisterReq = new UserRegisterReq();
        List<UserInfo> users = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserID("test124");
        userInfo.setNickname("test124");
        userInfo.setCreateTime(System.currentTimeMillis());
        users.add(userInfo);
        userRegisterReq.setUsers(users);
        userRegisterReq.setSecret("openIM123");
        OpenImResult<String> result = openImApiUserRest.userRegister(openImToken, userRegisterReq);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserID("2837113445");
        userInfo.setNickname("justin_12");
        UpdateUserInfoReq req = new UpdateUserInfoReq();
        req.setUserInfo(userInfo);
        OpenImResult<String> result = openImApiUserRest.updateUserInfo(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getUsers() {
        GetPaginationUsersReq req = new GetPaginationUsersReq();
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<GetPaginationUsersResp> result = openImApiUserRest.getUsers(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getAllUsersID() {
        GetAllUserIDReq req = new GetAllUserIDReq();
        req.setUserIDs(Arrays.asList("2837113445"));
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<GetAllUserIDResp> result = openImApiUserRest.getAllUsersID(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getUsersStatus() {
        GetUserStatusReq req = new GetUserStatusReq();
        req.setUserID("2837113445");
        OpenImResult<GetUserStatusResp> result = openImApiUserRest.getUsersStatus(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getUsersOnlineStatus() {
        GetUsersOnlineStatusReq req = new GetUsersOnlineStatusReq();
        req.setUserIDs(Arrays.asList("2837113445"));
        OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>> result = openImApiUserRest.getUsersOnlineStatus(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

}
