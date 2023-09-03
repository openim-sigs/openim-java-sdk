package org.ccs.openim.utils;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenimConfig;

/**
 * 需要初始化openimConfig这个配置
 *
 * @author chenjh
 */
@Slf4j
public class OpenimUtils {
    private static OpenimConfig openimConfig = new OpenimConfig();

    public static OpenimConfig getOpenimConfig() {
        return openimConfig;
    }

    public static void setOpenimConfig(OpenimConfig openimConfiguration) {
        BeanUtil.copyProperties(openimConfiguration, openimConfig);
        log.info("----openimConfig={}", openimConfig);
    }
}
