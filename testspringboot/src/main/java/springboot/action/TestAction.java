package springboot.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by zjc in 2020/5/13 0013
 */
@Controller
@RequestMapping(value = "test")
public class TestAction {
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public String testPage(@RequestParam(name = "json")String name ){

        return name;
    }
    @RequestMapping(value = "/requset",method = RequestMethod.POST)
    @ResponseBody
    public String testRequest(HttpServletRequest request, HttpServletResponse response){
        return "req";
    }
    @RequestMapping(value = "/header",method = RequestMethod.POST)
    @ResponseBody
    public String testRequestHeader(@RequestHeader(name="id")String id){
        return "header";
    }
}
