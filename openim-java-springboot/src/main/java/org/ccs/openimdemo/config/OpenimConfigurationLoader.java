package org.ccs.openimdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OpenimConfigurationLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired(required = false)
    private OpenimConfiguration openimConfiguration;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (openimConfiguration != null) {
            OpenimUtils.setOpenimConfig(openimConfiguration);
        }
    }
}
