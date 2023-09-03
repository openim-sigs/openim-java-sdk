package org.ccs.openimdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"org.ccs.openim","org.ccs.openimdemo"})
public class OpenimDemoApplication {
    public static final Logger logger = LoggerFactory.getLogger(OpenimDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OpenimDemoApplication.class, args);
    }


}
