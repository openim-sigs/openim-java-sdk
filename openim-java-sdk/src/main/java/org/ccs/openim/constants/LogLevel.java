package org.ccs.openim.constants;

/**
 * 日志打印级别
 *
 * @author chenjh
 */
public enum LogLevel {
    /**
     * Debug
     */
    DEBUG(5, "Debug"),
    /**
     * Info
     */
    INFO(4, "Info"),
    /**
     * Warn
     */
    WARN(3, "Warn"),
    /**
     * Error
     */
    ERROR(2, "Error"),
    /**
     * Fatal
     */
    FATAL(1, "Fatal");
    private final int level;
    private final String levelCode;

    LogLevel(int level, String levelCode) {
        this.level = level;
        this.levelCode = levelCode;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public int getLevel() {
        return level;
    }

    public static LogLevel parse(int level) {
        switch (level) {
            case 5:
                return DEBUG;
            case 4:
                return INFO;
            case 3:
                return WARN;
            case 2:
                return ERROR;
            case 1:
                return FATAL;
        }
        return null;
    }
}
