package org.ccs.openim.utils;

import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


/**
 * 支持更换接口调用方式
 */
@Slf4j
public class HttpRequestUtils {
    public static final boolean HTTP_GET_TYPE_HUTTOL = true;

    public static HttpResponse exchange(String url, String body, Map<String, String> httpHeaders) {
        HttpResponse exchanges = HttpRequest.post(url).headerMap(httpHeaders, true).body(body).execute();

        HttpStatus httpStatus = HttpStatus.resolve(exchanges.getStatus());
        if(httpStatus!=HttpStatus.OK){
            log.error("----exchange--url={} statusCode={} error={}", url, httpStatus, exchanges.body());
            throw new HttpException(httpStatus+","+exchanges.body());
        }
        return exchanges;
    }
}
