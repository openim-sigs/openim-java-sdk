package org.ccs.openim.constants;

/**
 * 验证码发送类型
 */
public enum VerificationCodeType {
    /**
     * 用户注册
     */
    Register(1, "Register"),
    /**
     * 重置密码
     */
    ResetPassword(2, "ResetPassword"),
    /**
     * 登入
     */
    Login(3, "Login");
    private final int type;
    private final String typeName;

    VerificationCodeType(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

    public static VerificationCodeType parse(int type) {
        switch (type) {
            case 1:
                return Register;
            case 2:
                return ResetPassword;
            case 3:
                return Login;
            default:
                return null;
        }
    }
}
