package springboot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.testng.TestNG;
import springboot.testng.core.EqualResultExpect;
import springboot.testng.core.dto.HandlerParams;
import springboot.testng.core.handler.HandlerStart;
import springboot.testng.core.imp.*;
import springboot.testng.utils.HttpModeUtil;
import springboot.vo.TestApiVO;

/**
 * create by zjc in 2020/5/14 0014
 */
@Controller
@RequestMapping(value = "api")
public class TestApiAction {
    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    @ResponseBody
    public String testApi(@RequestHeader(name="seq") String seq, @RequestHeader(name="opt")String opt, @RequestBody TestApiVO vo){
        if (vo.getUser()=="test" && vo.getPassWrod() == "test1234"){
            return "success";

        }
        return "false";
    }
    @RequestMapping(value = "/qry",method = RequestMethod.POST)
    @ResponseBody
    public TestApiVO qryApi(@RequestHeader(name="seq") String seq, @RequestHeader(name="opt")String opt, @RequestBody TestApiVO vo){
        if (vo.getUser().equals("test") && vo.getPassWrod() .equals("test1234")){
          vo.setUserName("张三");
        }
      return vo;
    }
    @RequestMapping(value = "/Excel",method = RequestMethod.GET)
    @ResponseBody
    public String testExcel(){
        HttpModeUtil.putDateExport("Excel", new ExcelDateExport());
        HttpModeUtil.putDateProvider("Excel",new ExcelDateProvider());
        HttpModeUtil.putMode("JSON",new HttpPostJosn());
        HttpModeUtil.putRespAnalysis("JSON",new JsonRespAnalysis());
        HttpModeUtil.putResultExpect("Equal",new EqualResultExpect());
        HandlerParams handle = new HandlerParams();
        handle.setUrl("http://127.0.0.1:8080/api/qry");
        handle.setFilePath("E:\\test\\apiqry.xlsx");
        handle.setOutFilePath("E:\\test\\apiqryresult.xlsx");
        handle.setDataProviderName("Excel");
        handle.setHttpModeName("JSON");
        handle.setDateExportName("Excel");
        handle.setRespAnalysisName("JSON");
        handle.setResultExpectName("Equal");
        new HandlerStart().run(handle);
        return null;
    }
}
