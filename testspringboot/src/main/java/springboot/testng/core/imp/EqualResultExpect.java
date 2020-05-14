package springboot.testng.core.imp;

import springboot.testng.core.ResultExpect;

import java.util.Map;
import java.util.Set;

/**
 * create by zjc in 2020/5/13 0013
 */
public class EqualResultExpect implements ResultExpect {
    @Override
    public boolean compare(Map<String, String> result, Map<String, String> expect) {
        if (expect == null || expect.isEmpty() ) {
            return true;
        }
        Set<String> keySet = expect.keySet();
        if (result == null) {
            return  false;
        }
        for (String s : keySet){
            boolean equals = expect.get(s).equals(result.get(s));
            if (!equals) {
                return false;
            }

        }
        return true;
    }
}
