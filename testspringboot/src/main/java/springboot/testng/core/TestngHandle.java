package springboot.testng.core;

import org.testng.annotations.*;

import java.util.Map;

/**
 * create by zjc in 2020/5/11 0011
 */
public interface TestngHandle {
    @Test(dataProvider = "dp")
    public void function(Map<String, String> header, Map<String, String> param, Map<String, String> resultMap) ;

    @BeforeMethod
    public void beforeMethod() ;

    @AfterMethod
    public void afterMethod() ;


    @DataProvider
    public Object[][] dp() ;
    @BeforeClass
    public void beforeClass() ;

    @AfterClass
    public void afterClass() ;
    @BeforeTest
    public void beforeTest() ;

    @AfterTest
    public void afterTest() ;
    @BeforeSuite
    public void beforeSuite() ;

    @AfterSuite
    public void afterSuite() ;



}
