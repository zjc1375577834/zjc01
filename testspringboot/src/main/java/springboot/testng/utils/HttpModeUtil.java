package springboot.testng.utils;


import springboot.testng.core.*;
import springboot.testng.core.dto.HandlerParams;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HttpModeUtil {
	private static Map<String , HttpMode> modeMap = new HashMap<String, HttpMode>();
	private static Map<String, DateProvider> dateProviderMap = new HashMap<>();
	private static Map<String, RespAnalysis> respAnalysisMap = new HashMap<>();
	private static Map<String, ResultExpect> resultExpectMap =new HashMap<>();
	private static Map<String, DateExport> dateExportMap = new HashMap<>();
	private static final List<HandlerParams> paramsList = new LinkedList<>();
	public static HttpMode getMode(String name) {
	    return modeMap.get(name);
    }
    public static boolean putMode(String name, HttpMode mode){
        HttpMode httpMode = modeMap.get(name);
        if (httpMode != null) {
            return false;
        }
        modeMap.put(name,mode);
        return true;
    }
    public static  DateProvider getDateProvider(String name) {
	    return dateProviderMap.get(name);
    }
    public static boolean putDateProvider(String name, DateProvider dateProvider){
        DateProvider provider = dateProviderMap.get(name);
        if (provider != null) {
            return false;
        }
        dateProviderMap.put(name,dateProvider);
        return true;
    }
    public static  RespAnalysis getRespAnalysis(String name) {
        return respAnalysisMap.get(name);
    }
    public static boolean putRespAnalysis(String name, RespAnalysis respAnalysis){
        RespAnalysis provider = respAnalysisMap.get(name);
        if (provider != null) {
            return false;
        }
        respAnalysisMap.put(name,respAnalysis);
        return true;
    }
    public static  ResultExpect getResultExpect(String name) {
        return resultExpectMap.get(name);
    }
    public static boolean putResultExpect(String name, ResultExpect resultExpect){
        ResultExpect provider = resultExpectMap.get(name);
        if (provider != null) {
            return false;
        }
        resultExpectMap.put(name,resultExpect);
        return true;
    }
    public static  DateExport getDateExport(String name) {
        return dateExportMap.get(name);
    }
    public static boolean putDateExport(String name, DateExport dateExport){
        DateExport provider = dateExportMap.get(name);
        if (provider != null) {
            return false;
        }
        dateExportMap.put(name,dateExport);
        return true;
    }

    public static HandlerParams getParams() {
	    HandlerParams params;
	    synchronized (paramsList) {
	        if (paramsList.isEmpty()){
	            params= new HandlerParams();
            }else {
                params = paramsList.remove(0);
            }
        }
        return params;
    }
    public static void putParams(HandlerParams params) {
        synchronized (paramsList) {
            paramsList.add(params);
        }
    }
}
