package springboot.testng.core;

import java.util.Map;

/**
 * create by zjc in 2020/5/13 0013
 */
public interface ResultExpect {
    boolean compare(Map<String, String> result, Map<String, String> expect);
}
