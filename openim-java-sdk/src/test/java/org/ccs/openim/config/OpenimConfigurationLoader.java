//package org.ccs.openim.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.ccs.openim.base.OpenimConfig;
//import org.ccs.openim.utils.OpenimUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class OpenimConfigurationLoader implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired(required = false)
//    private OpenimConfig openimDefaultConfiguration;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        if (openimDefaultConfiguration != null) {
//            OpenimUtils.setOpenimConfig(openimDefaultConfiguration);
//        }
//    }
//}
