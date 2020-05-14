package springboot.testng.core.imp;

import springboot.testng.core.DateProvider;
import springboot.testng.core.dto.ParamsMap;
import springboot.testng.utils.ExcelReadUtil;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public class ExcelDateProvider implements DateProvider {
    public List<ParamsMap> getDate(String url) {
        ExcelReadUtil readUtil = new ExcelReadUtil(url);
        List<String> hander = readUtil.readLine(0);
        List<String> keyName = readUtil.readNextLine();
        int head = hander.indexOf("header");
        int param = hander.indexOf("body");
        int result = hander.indexOf("result");
        List<String> headerName = keyName.subList(head, param);
        List<String> paramName = keyName.subList(param, result);
        List<String> resultName = keyName.subList(result, keyName.size() );
        List<ParamsMap> list = new LinkedList<>();
        for (int i = 1;i< readUtil.getRows();i++) {
            List<String> strings = readUtil.readNextLine();
            Map<String, String> headerMap = putList(headerName, strings.subList(head, param));
            Map<String, String> paramMap = putList(paramName, strings.subList(param, result));
            Map<String, String> resultMap = putList(resultName, strings.subList(result, keyName.size()));
            ParamsMap paramsMap = new ParamsMap();
            paramsMap.setHeader(headerMap);
            paramsMap.setParams(paramMap);
            paramsMap.setResults(resultMap);
            list.add(paramsMap);

        }
        return list;
    }

    @Override
    public List<String> getKeyName(String url) {
        ExcelReadUtil readUtil = new ExcelReadUtil(url);
        List<String> hander = readUtil.readLine(0);
        List<String> keyName = readUtil.readNextLine();
        int head = hander.indexOf("header");
        List<String> strings = keyName.subList(head, hander.size() - 1);
        return strings;
    }

    private Map<String,String> putList(List<String> key ,List<String> value){
        HashMap<String,String> map = new HashMap<String,String>();
        for (int i =0 ;i< key.size() && i< value.size();i++) {
            map.put(key.get(i),value.get(i));
        }
        return map;
    }
}
