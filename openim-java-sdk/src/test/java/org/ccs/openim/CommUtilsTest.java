package org.ccs.openim;

import org.ccs.openim.utils.CommUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CommUtilsTest {
    @Test
    public void asUrlParams() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("roomId", "123");
        paramMap.put("event", "test");
        paramMap.put("tryUrl", "aaaa");
        String url = CommUtils.asUrlParams(paramMap);
        System.out.println(url);
    }


    @Test
    public void computeIfAbsent() {
        Map<String, Boolean> paramMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Boolean key = paramMap.get("key");
            if (key == null) {
                key = true;
                paramMap.put("key", key);
                System.out.println("aa-" + i);
            }

            String key2 = "123";
            final int iFinal = i;
            if (paramMap.computeIfAbsent(key2, k -> {
                System.out.println(iFinal);
                return true;
            }) == null) {

            }
        }
        System.out.println(paramMap);
    }
}
