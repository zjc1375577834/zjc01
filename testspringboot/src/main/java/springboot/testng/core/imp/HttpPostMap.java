package springboot.testng.core.imp;

import springboot.testng.core.HttpMode;
import springboot.testng.utils.HttpUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public class HttpPostMap extends HttpMode {

    public String sendMode(Map<String, String> header, Map<String, String> params) {
        Map<String,Object> map = new HashMap<String, Object>();
        if (params != null) {
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                map.put(next.getKey(),next.getValue());
            }
        }
        String result = null;
        if (this.proxyId == null ){
            result = HttpUtils.doPost(this.url,header,map);
        }else  {
            result = HttpUtils.doPostHttp(this.url,header,map,this.proxyId);
        }
       return result ;

    }


}
