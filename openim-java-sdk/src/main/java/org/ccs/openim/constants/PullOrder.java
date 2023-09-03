package org.ccs.openim.constants;

/**
 * 数据排序方式
 */
public enum PullOrder {
    /**
     * 正序
     */
    ASC(0, "Asc"),
    /**
     * 反序
     */
    DESC(1, "Desc");
    private final int type;
    private final String typeName;

    PullOrder(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

    public static PullOrder parse(int status) {
        switch (status) {
            case 0:
                return ASC;
            case 1:
                return DESC;
        }
        return null;
    }
}
