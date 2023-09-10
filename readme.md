# openim-sdk

openim api java调用sdk 无spring版


# 目的：
- 实现一套openim的java版sdk，方便java快速集成开发



# 参考

- https://github.com/OpenIMSDK/Open-IM-Server
- https://github.com/OpenIMSDK/chat

## 使用

* 1 maven引入依赖包

```xml
<dependency>
    <groupId>cn.org.opendfl</groupId>
    <artifactId>openim-java-sdk</artifactId>
    <version>0.5-nospring</version>
</dependency>
```

* 2 openim配置
```yaml
openim:
  api: http://openim-web.host.fit
#  下面可以不配置，默认按以下规则生成
#  apiApi: http://openim-web.host.fit/api
#  apiChat: http://openim-web.host.fit/chat
#  apiAdmin: http://openim-web.host.fit/complete_admin
  secret: openIM123
  adminAccount: openIMAdmin
  adminPwd: openIMAdmin
  #预留功能，支持每个请求，自动带个header authKey参数
  authKey: authKey
  #是否校验请求参数
  requestParamValid: true
```

* 3 调用示例
```java
private OpenImService openImService = new OpenImService();
public void login(){
    String operationId = IdUtil.fastUUID();
    LoginReq loginReq = new LoginReq();
    loginReq.setAccount("openIMAdmin");
    loginReq.setPassword("de84e3477e4fcddc54c9bfbeac4aca2d");
    OpenImResult<AdminLoginResp> result = openImService.admin().user().login(loginReq, operationId);
}

public void getClientConfig() {
    OpenImResult<GetClientConfigResp> result = openImService.admin().clientConfig().getClientConfig(openImToken);
    System.out.println(JSONUtil.toJsonStr(result));
    TestCase.assertTrue(result.getErrMsg(), result.isOk());
}
```
