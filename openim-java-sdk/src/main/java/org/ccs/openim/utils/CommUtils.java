package org.ccs.openim.utils;

import cn.hutool.core.text.CharSequenceUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class CommUtils {
    private CommUtils() {

    }


    /**
     * @return
     */
    public static boolean startWithChar(String str, char ch) {
        if (str == null || str.length() < 1) {
            return false;
        }
        return str.charAt(0) == ch;
    }

    /**
     * @return
     */
    public static boolean endWithChar(String str, char ch) {
        if (str == null || str.length() < 1) {
            return false;
        }
        return str.charAt(str.length() - 1) == ch;
    }

    /**
     * 只要确保你的编码输入是正确的,就可以忽略掉 UnsupportedEncodingException
     */
    public static String asUrlParams(Map<String, String> source) {
        Iterator<String> it = source.keySet().iterator();
        StringBuilder paramStr = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = source.get(key);
            if (CharSequenceUtil.isBlank(value)) {
                continue;
            }
            try {
                // URL 编码
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // do nothing
            }
            paramStr.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return paramStr.substring(1);
    }

    public static String appendUrl(String url, String path) {
        if (url == null) {
            return null;
        }
        if (path == null) {
            path = "";
        }
        if (endWithChar(url, '/') && startWithChar(path, '/')) {//相当于startsWith
            return url + path.substring(1);
        } else if (endWithChar(url, '/') || startWithChar(path, '/')) {//相当于startsWith
            return url + path;
        }

        return url + "/" + path;
    }

    public static String getBaseUrl(String url) {
        int idx = url.indexOf("://");
        if (idx > 0) {
            int idxEnd = idx + 3;
            String tmp = url.substring(idxEnd);
            idx = tmp.indexOf('/');
            if (idx > 0) {
                tmp = tmp.substring(0, idx);
                idxEnd += tmp.length();
            }
            return url.substring(0, idxEnd);
        }
        return url;
    }

    public static String trimUrlDomainAndParam(String uri) {
        if (uri == null) {
            return null;
        }
        if (uri.indexOf("http") >= 0) {
            String baseUrl = getBaseUrl(uri);
            String path = uri.substring(baseUrl.length());
            uri = path;
        }
        int idx = uri.indexOf("?");
        if (idx > 0) {
            uri = uri.substring(0, idx);
        }
        return uri;
    }

    public static String trimUrlParam(String uri) {
        if (uri == null) {
            return null;
        }
        if (uri.indexOf('?') >= 0) {
            return uri.substring(0, uri.indexOf('?'));
        }
        return uri;
    }

    public static String ignoreHttp(String url) {
        if (url == null) {
            return null;
        }
        url = url.trim();
        if (url.startsWith("http://")) {
            url = url.substring("http://".length());
        } else if (url.startsWith("https://")) {
            url = url.substring("https://".length());
        }
        return url;
    }

    public static String addUrlParam(String url, String param) {
        if (url == null) {
            return null;
        }
        if (param == null) {
            return url;
        }
        if (url.indexOf('?') > 0) {
            url = url + "&" + param;
        } else {
            url = url + "?" + param;
        }
        return url;
    }
}
