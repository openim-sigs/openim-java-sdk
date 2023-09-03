package org.ccs.openim.constants;

/**
 * 加入来源选项
 *
 * @author chenjh
 */
public enum JoinSource {
    /**
     * 通过邀请
     */
    Invitation(2, "Invitation"),
    /**
     * 通过搜索
     */
    Search(3, "Search"),
    /**
     * 通过二维码
     */
    QrCode(4, "QrCode");
    private final int type;
    private final String typeName;

    JoinSource(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

    public static JoinSource parse(int type) {
        switch (type) {
            case 2:
                return Invitation;
            case 3:
                return Search;
            case 4:
                return QrCode;
        }
        return null;
    }
}