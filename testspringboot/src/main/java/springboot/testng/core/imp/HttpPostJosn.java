package springboot.testng.core.imp;

import com.alibaba.fastjson.JSON;
import springboot.testng.core.HttpMode;
import springboot.testng.utils.HttpUtils;

import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public class HttpPostJosn extends HttpMode {
    public String sendMode(Map<String, String> header, Map<String, String> params) {

        JSON json = (JSON)JSON.toJSON(params);

        String result = null;
        if (this.proxyId == null ){
            result = HttpUtils.doPostHttp(this.url,header,json);
        }else  {
            result = HttpUtils.doPostHttp(this.url,header,json,this.proxyId);
        }
        return result;
    }
}
