package org.ccs.openim.api.third.resp;

import lombok.Data;
import org.ccs.openim.api.vo.KeyValues;


import java.util.List;
import java.util.Map;

@Data
public class InitiateFormDataResp {
    private String id;
    private String url;
    private String file;
    private List<KeyValues> header;
    private Map<String, String> formData;
    private Long expires;
    private List<Integer> successCodes;
}
