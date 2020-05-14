package springboot.testng.core.imp;

import com.alibaba.fastjson.JSONObject;
import springboot.testng.core.RespAnalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * create by zjc in 2020/5/12 0012
 */
public class JsonRespAnalysis implements RespAnalysis {

    @Override
    public Map<String, String> analysis(String resp) {
        JSONObject jsonStr = JSONObject.parseObject(resp);
        Set<String> keySet = jsonStr.keySet();
        HashMap<String, String> map = new HashMap<>();
        for (String key : keySet) {
            Object o = jsonStr.get(key);
            if (o == null) {
                map.put(key,null);
            }else {
                map.put(key, o.toString());
            }
        }
        return map;
    }
}
