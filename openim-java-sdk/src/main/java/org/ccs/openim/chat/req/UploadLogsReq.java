package org.ccs.openim.chat.req;

import lombok.Data;

import java.util.List;

@Data
public class UploadLogsReq {
    private Integer platform;
    private List<FileURL> fileURLs;
    private String systemType;
    private String version;
    private String ex;
}
