package org.ccs.openim.constants;

/**
 * 平台描述
 */
public enum IMPlatform {
    IOS(1, "iOS"),
    ANDROID(2, "Android"),
    WINDOWS(3, "windows"),
    MAC_OS(4, "MacOSX"),
    WEB(5, "Web"),
    MINI_PROGRAM(6, "MiniProgram"),
    LINUX(7, "Linux"),
    ANDROID_PAD(8, "AndroidPad"),
    IPAD(9, "iPad");
    private final int type;
    private final String typeName;

    IMPlatform(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public static IMPlatform parse(int type) {
        switch (type) {
            case 1:
                return IOS;
            case 2:
                return ANDROID;
            case 3:
                return WINDOWS;
            case 4:
                return MAC_OS;
            case 5:
                return WEB;
            case 6:
                return MINI_PROGRAM;
            case 7:
                return LINUX;
            case 8:
                return ANDROID_PAD;
            case 9:
                return IPAD;
        }
        return null;
    }
}
