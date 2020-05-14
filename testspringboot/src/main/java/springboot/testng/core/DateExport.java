package springboot.testng.core;

import java.util.List;

/**
 * create by zjc in 2020/5/13 0013
 */
public interface DateExport {
    void export(String file, List<List<String>> result);
}
