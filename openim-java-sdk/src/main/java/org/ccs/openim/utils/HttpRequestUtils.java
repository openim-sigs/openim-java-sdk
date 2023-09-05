package org.ccs.openim.utils;

import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;


/**
 * 支持更换接口调用方式
 */
@Slf4j
public class HttpRequestUtils {
    public static final boolean HTTP_GET_TYPE_HUTTOL = true;

    public static ResponseEntity<String> exchange(String url, String body, HttpHeaders httpHeaders) {
        HttpResponse exchanges = HttpRequest.post(url).header(httpHeaders).body(body).execute();
        HttpStatus httpStatus = HttpStatus.valueOf(exchanges.getStatus());
        return new ResponseEntity<>(exchanges.body(), httpStatus);

    }

    /**
     * 保留与RestTemplate的调用方式
     * ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);
     * 可替换为
     * ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);
     *
     * @param url
     * @param httpMethod
     * @param formEntity
     * @param classType
     * @return
     */
    public static ResponseEntity<String> exchange(String url, HttpMethod httpMethod, HttpEntity<String> formEntity, Class<?> classType) {
        HttpResponse exchanges = HttpRequest.post(url).header(formEntity.getHeaders()).body(formEntity.getBody()).execute();
        HttpStatus httpStatus = HttpStatus.valueOf(exchanges.getStatus());
        if(httpStatus!=HttpStatus.OK){
            log.error("----exchange--url={} statusCode={} error={}", url, httpStatus, exchanges.body());
            throw new HttpException(httpStatus+","+exchanges.body());
        }
        return new ResponseEntity<>(exchanges.body(), httpStatus);

    }
}
