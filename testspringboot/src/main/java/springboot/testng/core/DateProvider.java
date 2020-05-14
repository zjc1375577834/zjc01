package springboot.testng.core;



import springboot.testng.core.dto.ParamsMap;

import java.util.List;

/**
 * create by zjc in 2020/5/12 0012
 */
public interface DateProvider {
    List<ParamsMap> getDate(String url);
    List<String> getKeyName(String url);
}
