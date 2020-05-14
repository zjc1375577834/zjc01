package springboot.testng.core.handler;

import lombok.Setter;
import org.testng.TestNG;
import springboot.testng.core.dto.HandlerParams;
import springboot.testng.core.imp.HttpTestngHandle;
import springboot.testng.utils.HttpModeUtil;

/**
 * create by zjc in 2020/5/14 0014
 */
public class HandlerStart {


    public void run(HandlerParams params) {
        HttpModeUtil.putParams(params);
        TestNG testNG = new TestNG();
        HttpTestngHandle handle = new HttpTestngHandle();
        Class[] classes ={handle.getClass()};
        testNG.setTestClasses(classes);
        testNG.run();
    }
}
