package springboot.testng.core.imp;

import org.testng.TestNG;
import org.testng.annotations.*;

/**
 * create by zjc in 2020/5/12 0012
 */
public class HttpTestngHandleTest  {
    private String url;
    private String mothd;
    private String http;
    private String structe;
    private String poxyIp;
    @Test(dataProvider = "dp")
    public void function(String n, String s) {
            System.out.println(n+"--"+s);
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[]{"1","a"},
                new Object[]{"2","b"}
        };
    }

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeTest
    public void beforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }

    @BeforeSuite
    public void beforeSuite() {


    }

    @AfterSuite
    public void afterSuite() {

    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        Class[] classes = {HttpTestngHandleTest.class};
        testNG.setTestClasses(classes);
        testNG.run();
    }
}
