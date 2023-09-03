package org.ccs.openim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"org.ccs.openim"})
public class OpenimApplication {
    public static final Logger logger = LoggerFactory.getLogger(OpenimApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OpenimApplication.class, args);
    }


}
