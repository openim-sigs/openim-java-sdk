package org.ccs.openim.constants;

/**
 * IP限制类型
 */
public enum LimitIpType {
    /**
     * 无
     */
    NIL(0, "NIL"),
    /**
     * 都不限制
     */
    EMPTY(1, "EMPTY"),
    /**
     * 仅限制登录
     */
    OnlyLoginIP(2, "OnlyLoginIP"),
    /**
     * 仅限制注册
     */
    OnlyRegisterIP(3, "OnlyRegisterIP"),
    /**
     * 限制登录
     */
    LoginIP(4, "LoginIP"),
    /**
     * 限制注册
     */
    RegisterIP(5, "RegisterIP"),
    /**
     * 限制登录注册
     */
    LoginRegisterIP(6, "LoginRegisterIP");
    private final int type;
    private final String typeName;

    LimitIpType(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

    public static LimitIpType parse(int type) {
        switch (type) {
            case 0:
                return NIL;
            case 1:
                return EMPTY;
            case 2:
                return OnlyLoginIP;
            case 3:
                return OnlyRegisterIP;
            case 4:
                return LoginIP;
            case 5:
                return RegisterIP;
            case 6:
                return LoginRegisterIP;
            default:
                return null;
        }
    }
}
