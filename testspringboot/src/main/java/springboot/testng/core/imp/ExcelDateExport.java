package springboot.testng.core.imp;

import org.apache.poi.ss.usermodel.Sheet;
import springboot.testng.core.DateExport;
import springboot.testng.utils.ExcelExportUtil;


import java.util.List;

/**
 * create by zjc in 2020/5/13 0013
 */
public class ExcelDateExport implements DateExport {
    @Override
    public void export(String file, List<List<String>> result) {
        ExcelExportUtil exportUtil = new ExcelExportUtil(file);
        Sheet sheet = exportUtil.createSheet("result");
        if (result == null) {
            exportUtil.writeFile();
            return;
        }
        for (List<String> list : result) {
            exportUtil.writeLine(list);
        }
        exportUtil.writeFile();
    }
}
