package springboot.testng.core.dto;

import lombok.Data;
import lombok.Setter;

/**
 * create by zjc in 2020/5/14 0014
 */
@Data
public class HandlerParams {

    private String url;
    private String filePath;
    private String outFilePath;
    private Integer port;
    private String proxyIp;
    private String httpModeName;
    private String dataProviderName;
    private String resultExpectName;
    private String respAnalysisName;
    private String dateExportName;
}
