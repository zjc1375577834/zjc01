package springboot.testng.core;


import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public interface HttpMsgStructure {
    Map<String,String > headerSendOut(Map<String, String> map);
    <T> T paramsSendOut(Map<String, String> map, T t);
}
