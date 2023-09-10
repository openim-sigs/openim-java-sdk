//package org.ccs.openimdemo.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
//
//import java.nio.charset.StandardCharsets;
//
//@Configuration
//public class RestTemplateConfig {
//
//    @Bean
//    @ConditionalOnMissingBean(name="restTemplate")
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        RestTemplate restTemplate = new RestTemplate(factory);
////        restTemplate.getInterceptors().add(new RestTemplateLogRecordInterceptor());
//        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        return restTemplate;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name="simpleClientHttpRequestFactory")
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
////        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(factory);
//        factory.setReadTimeout(60000);
//        factory.setConnectTimeout(60000);
//        return factory;
//    }
//}