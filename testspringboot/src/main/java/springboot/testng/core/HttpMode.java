package springboot.testng.core;

import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public abstract class HttpMode {
    protected String url ;
    protected String proxyId;
    protected Integer port;
   public abstract String sendMode(Map<String,String> header, Map<String ,String> params);
     public void setUrl(String url){
         this.url = url;
     }
    public void setPoxyIp(String ip){
         this.proxyId = ip;
    }
    public void setPort(Integer port) {
         this.port = port;
    }

}
