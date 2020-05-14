package springboot.testng.core.imp;

import lombok.Data;
import lombok.Setter;
import org.testng.annotations.*;
import springboot.testng.*;
import springboot.testng.core.*;
import springboot.testng.core.dto.HandlerParams;
import springboot.testng.core.dto.ParamsMap;
import springboot.testng.utils.HttpModeUtil;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * create by zjc in 2020/5/12 0012
 */

public class HttpTestngHandle implements TestngHandle {

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
    private HttpMode httpMode;
    private DateProvider dateProvider;
    private ResultExpect resultExpect;
    private RespAnalysis respAnalysis;
    private DateExport dateExport;
    private List<List<String>> result;
    private boolean isFast = true;
    @Test(dataProvider = "dp")
    public void function(Map<String,String> header, Map<String,String > param,Map<String,String> resultMap) {
        String resp = this.httpMode.sendMode(header, param);
        Map<String, String> analysis = this.respAnalysis.analysis(resp);
        boolean compare = this.resultExpect.compare(analysis, resultMap);
        if (isFast) {
            isFast = false;
            LinkedList<String> strings = new LinkedList<>();
            strings.addAll(header.keySet());
            strings.addAll(param.keySet());
            strings.addAll(resultMap.keySet());
            strings.add("resp");
            Set<String> strings1 = analysis.keySet();
            strings.addAll(strings1);
            strings.add("isCompare");
            this.result.add(strings);
        }
        LinkedList<String> list = new LinkedList<>();
        list.addAll(header.values());
        list.addAll(param.values());
        list.addAll(resultMap.values());
        list.add(resp);
        list.addAll(analysis.values());
        list.add(String.valueOf(compare));
        this.result.add(list);




    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @DataProvider
    public Object[][] dp() {
        List<ParamsMap> date = this.dateProvider.getDate(this.filePath);
        int size = date.size();
        Map<String,String>[][] maps = new Map[size][];

        for (int i=0; i < size;i++ ) {
            ParamsMap paramsMap = date.get(i);
            Map<String,String>[] maps1 = new Map[3];
            maps1[0]=paramsMap.getHeader();
            maps1[1] = paramsMap.getParams();
            maps1[2] = paramsMap.getResults();
            maps[i] = maps1;
        }

        return maps;
    }

    @BeforeClass
    public void beforeClass() {
        HandlerParams params = HttpModeUtil.getParams();
        this.url=params.getUrl();
        this.port=params.getPort();
        this.dataProviderName = params.getDataProviderName();
        this.dateExportName = params.getDateExportName();
        this.respAnalysisName = params.getRespAnalysisName();
        this.filePath = params.getFilePath();
        this.outFilePath = params.getOutFilePath();
        this.httpModeName = params.getHttpModeName();
        this.resultExpectName = params.getResultExpectName();
        this.proxyIp = params.getProxyIp();
        HttpMode mode = HttpModeUtil.getMode(this.httpModeName);
        mode.setUrl(url);
        mode.setPort(port);
        mode.setPoxyIp(proxyIp);
        this.httpMode = mode;
        this.dateProvider = HttpModeUtil.getDateProvider(this.dataProviderName);
        this.respAnalysis= HttpModeUtil.getRespAnalysis(this.respAnalysisName);
        this.resultExpect = HttpModeUtil.getResultExpect(this.resultExpectName);
        this.dateExport = HttpModeUtil.getDateExport(this.dateExportName);
        this.result = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        strings.add(this.url);
        this.result.add(strings);

    }

    @AfterClass
    public void afterClass() {
        dateExport.export(outFilePath,result);
    }

    @BeforeTest
    public void beforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }

    @BeforeSuite
    public void beforeSuite() {


    }

    @AfterSuite
    public void afterSuite() {

    }
}
