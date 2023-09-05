package org.ccs.openim.constants;

/**
 * 账号类型
 */
public enum AccountType {
    /**
     * Email
     */
    Email("email", "Email"),
    /**
     * Phone
     */
    Phone("phone", "Phone"),
    /**
     * Account
     */
    Account("account", "Account");

    private final String type;
    private final String typeName;

    AccountType(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public static AccountType parse(String type) {
        switch (type) {
            case "email":
                return Email;
            case "phone":
                return Phone;
            case "account":
                return Account;
        }
        return null;
    }
}
